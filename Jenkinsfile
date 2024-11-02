pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Pull the code from GitHub
                git branch: 'main', url: 'https://github.com/v4224/static-web.git'
            }
        }

        stage('Deploy to Server') {
            steps {
                // Use SCP to copy files to the server
                // Replace `user@your-server:/path/to/deploy` with your server's details
                sh '''
                scp -r * user@your-server:/var/www/html
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
