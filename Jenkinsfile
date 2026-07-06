pipeline {
	agent {
	    label "docker-agent-alpine"
	}

	triggers {
		pollSCM '*/1 * * * *'
	}
	stages {
		stage('Verify') {
			steps {
				dir('todo_list') {
					sh "chmod +x ./cicd/00_verify.sh"
					sh "./cicd/00_verify.sh"
				}
			}
		}
		stage('Build') {
			steps {
				dir('todo-list') {
					sh 'chmod +x ./cicdcd/01_build.sh'
					sh './cicdcd/01_build.sh'
				}
			}
		}
		stage('Test') {
			steps {
				dir('todo_list') {
					sh 'chmod +x ./cicd/02_test.sh'
					sh './cicd/02_test.sh'
				}
			}
		}
		stage('Push') {
			steps {
				dir('todo_list') {
					sh 'chmod +x ./cicd/03_push.sh'
					sh './cicd/03_push.sh'
					echo "push image is done!"
				}
			}
		}
		stage('Deploy') {
            steps {
                dir('todo_list') {
                    sh 'chmod +x ./cicd/04_run.sh'
                    sh './cicd/04_run.sh'
                    echo "Docker compose is starting..."
                }
            }
        }
	}
}