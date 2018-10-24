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