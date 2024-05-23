pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    bat 'run-tests.bat'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']],
                        report: [[path: 'target/allure-report']]
                    ])
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/allure-report/**', allowEmptyArchive: true
        }
        success {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']],
                    report: [[path: 'target/allure-report']]
                ])
            }
        }
    }
}
