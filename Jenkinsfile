pipeline {
	agent {
	    label 'docker-agent-alpine'
	}

	triggers {
		pollSCM '*/1 * * * *'
	}
	stages {
		stage('Verify') {
			steps {
				sh "ls -l"
                sh "chmod +x ./ci-commands/00_verify.sh"
                sh "./ci-commands/00_verify.sh"
			}
		}
		stage('Build') {
			steps {
				sh 'chmod +x ./ci-commands/01_build.sh'
                sh './ci-commands/01_build.sh'
			}
		}
		stage('Test') {
			steps {
				sh 'chmod +x ./ci-commands/02_test.sh'
                sh './ci-commands/02_test.sh'
			}
		}
		stage('Push') {
			steps {
				sh 'chmod +x ./ci-commands/03_push.sh'
                sh './ci-commands/03_push.sh'
                echo "push image is done!"
			}
		}
		stage('Deploy') {
            steps {
                sh 'chmod +x ./ci-commands/04_run.sh'
                sh './ci-commands/04_run.sh'
                echo "Docker compose is starting..."
            }
        }
	}
}