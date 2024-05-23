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
                        results: [[path: 'allure-results']],
                        report: [[path: 'allure-report']]
                    ])
                }
            }
        }
    }
    post {
            always {
                archiveArtifacts artifacts: 'allure-report/**', allowEmptyArchive: true
            }
            success {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'allure-results']],
                        report: [[path: 'allure-report']]
                    ])
                }
            }
        }
}
