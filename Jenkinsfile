pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/chandraSekhar-alti/selenium-java-testng-allure.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    def mvnHome = tool name: 'Maven 3.9.6', type: 'maven'
                    try {
                        sh "${mvnHome}/bin/mvn clean test"
                    } catch (Exception e) {
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    def allureHome = tool name: 'allure', type: 'ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation'
                    sh "${allureHome}/bin/allure generate target/allure-results --clean -o target/allure-report"
                }
            }
        }
    }

    post {
        always {
            script {
                archiveArtifacts artifacts: 'target/allure-report/**'
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}