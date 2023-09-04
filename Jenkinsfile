pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                checkout scm
            }
        }

        stage('Build demo-2') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'cd demo_2 && mvn clean package -DskipTests'
            }
        }

        // stage('Deploy demo-2') {
        //     steps {
        //         // Copy the built .jar file to the EC2 instance
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/spring-mvn-pipeline/target/demo-1-build.jar root@3.111.51.62:~/'
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/spring-mvn-pipeline/Dockerfile root@3.111.51.62:~/'
                
        //         // SSH into the EC2 instance and deploy the .jar in Docker
        //         sh "ssh root@3.111.51.62 'docker stop demo-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker rm demo-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker build -t demo-1-build .'"
        //         sh "ssh root@3.111.51.62 'docker run -it -d -p 9091:9091 --name demo-1 demo-1-build'"
        //     }
        // }

        stage('Build test-1') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'cd test-1 && mvn clean package -DskipTests'
            }
        }

        // stage('Deploy test-1') {
        //     steps {
        //         // Copy the built .jar file to the EC2 instance
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/spring-mvn-pipeline/target/demo-1-build.jar root@3.111.51.62:~/'
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/spring-mvn-pipeline/Dockerfile root@3.111.51.62:~/'
                
        //         // SSH into the EC2 instance and deploy the .jar in Docker
        //         sh "ssh root@3.111.51.62 'docker stop demo-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker rm demo-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker build -t demo-1-build .'"
        //         sh "ssh root@3.111.51.62 'docker run -it -d -p 9090:9090 --name demo-1 demo-1-build'"
        //     }
        // }
    }
}
