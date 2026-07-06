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
				dir('todo_list') {
				    sh "ls -l"
					sh "chmod +x ./ci-commands/00_verify.sh"
					sh "./ci-commands/00_verify.sh"
				}
			}
		}
		stage('Build') {
			steps {
				dir('todo-list') {
					sh 'chmod +x ./ci-commandscd/01_build.sh'
					sh './ci-commandscd/01_build.sh'
				}
			}
		}
		stage('Test') {
			steps {
				dir('todo_list') {
					sh 'chmod +x ./ci-commands/02_test.sh'
					sh './ci-commands/02_test.sh'
				}
			}
		}
		stage('Push') {
			steps {
				dir('todo_list') {
					sh 'chmod +x ./ci-commands/03_push.sh'
					sh './ci-commands/03_push.sh'
					echo "push image is done!"
				}
			}
		}
		stage('Deploy') {
            steps {
                dir('todo_list') {
                    sh 'chmod +x ./ci-commands/04_run.sh'
                    sh './ci-commands/04_run.sh'
                    echo "Docker compose is starting..."
                }
            }
        }
	}
}