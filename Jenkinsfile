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
    }
    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']],
                    report: [[path: 'allure-report']]
                ])
            }
            archiveArtifacts artifacts: 'allure-report/**', allowEmptyArchive: true
        }
    }
}
