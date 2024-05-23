pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3.9.6', type: 'maven'
        ALLURE_HOME = tool name: 'allure', type: 'ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/chandraSekhar-alti/selenium-java-testng-allure.git'
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    try {
                        sh "${MAVEN_HOME}/bin/mvn clean test"
                    } catch (Exception e) {
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    sh "${ALLURE_HOME}/bin/allure generate target/allure-results --clean -o target/allure-report"
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/allure-results/**'
            archiveArtifacts artifacts: 'target/allure-report/**'
            publishHTML(target: [
                reportName : 'Allure Report',
                reportDir  : 'target/allure-report',
                reportFiles: 'index.html',
                alwaysLinkToLastBuild: true,
                keepAll: true
            ])
        }
        failure {
            echo 'Build failed! Check the test results and fix the issues.'
        }
        unstable {
            echo 'Build is unstable. Check the test results and fix the issues.'
        }
    }
}