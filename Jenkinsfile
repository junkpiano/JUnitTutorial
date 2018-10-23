pipeline {
    agent {
        docker { image 'openjdk:8-jdk-alpine' }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                gradlew('assemble')
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                gradlew('test')
            }

            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                gradlew("javadoc")
            }

            post {
                always {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/docs/javadoc', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
                }
            }
        }
    }
}

// execute Gradlew
def gradlew(command) {
    if(isUnix()) {
        sh "./gradlew ${command} --stacktrace"
    } else {
        bat "./gradlew.bat ${command} --stacktrace"
    }
}