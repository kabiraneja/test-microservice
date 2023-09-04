pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                checkout scm
            }
        }

        // stage('Build demo-2') {
        //     steps {
        //         // Build the Spring Boot application using Maven
        //         sh 'cd demo_2 && mvn clean package -DskipTests'
        //     }
        // }

        // stage('Deploy demo-2') {
        //     steps {
                
        //         sh "ssh root@3.111.51.62 'rm -rf /root/demo-2 || true'"
        //         sh "ssh root@3.111.51.62 'mkdir /root/demo-2'"
        //         sh "ssh root@3.111.51.62 'ls -l /root/demo-2'"
                
        //         // Copy the built .jar file to the EC2 instance
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/test-microservice/demo_2/target/demo-2.jar root@3.111.51.62:~/demo-2/'
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/test-microservice/demo_2/Dockerfile root@3.111.51.62:~/demo-2/'
                
        //         // SSH into the EC2 instance and deploy the .jar in Docker
        //         sh "ssh root@3.111.51.62 'docker stop demo-2 || true'"
        //         sh "ssh root@3.111.51.62 'docker rm demo-2 || true'"
        //         sh "ssh root@3.111.51.62 'docker rmi demo-2 ||true'"
        //         sh "ssh root@3.111.51.62 'docker build -t demo-2 /root/demo-2'"
        //         sh "ssh root@3.111.51.62 'docker run -it -d -p 9091:9091 --name demo-2 demo-2'"
        //     }
        // }

        // stage('Build test-1') {
        //     steps {
        //         // Build the Spring Boot application using Maven
        //         sh 'cd test-1 && mvn clean package -DskipTests'
        //     }
        // }

        // stage('Deploy test-1') {
        //     steps {
                
        //         sh "ssh root@3.111.51.62 'cd /root'"
        //         sh "ssh root@3.111.51.62 'rm -rf test-1 || true'"
        //         sh "ssh root@3.111.51.62 'mkdir test-1'"
                
        //         // Copy the built .jar file to the EC2 instance
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/test-microservice/test-1/target/test-1.jar root@3.111.51.62:~/test-1/'
        //         sh ' scp -i id_rsa /var/jenkins_home/workspace/test-microservice/test-1/Dockerfile root@3.111.51.62:~/test-1/'

        //         // SSH into the EC2 instance and deploy the .jar in Docker
        //         sh "ssh root@3.111.51.62 'docker stop test-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker rm test-1 || true'"
        //         sh "ssh root@3.111.51.62 'docker rmi test-1 ||true'"
        //         sh "ssh root@3.111.51.62 'docker build -t test-1 /root/test-1'"
        //         sh "ssh root@3.111.51.62 'docker run -it -d -p 9090:9090 --name test-1 test-1'"
        //     }
        // }



        stage('Build and Package Microservices') {
            steps {
                script {
                    def microservices = [
                        ['test-1', '9090'],
                        ['demo-2', '9091'],
                        // Add more microservices as needed: ['folder-name', 'port']
                    ]

                    for (def service in microservices) {
                        def serviceName = service[0]
                        def servicePort = service[1]

                        dir(serviceName) {
                            // Build the microservice using Maven (adjust the command as needed)
                            sh 'cd ${serviceName} && mvn clean package'

                            sh "ssh root@3.111.51.62 'cd /root'"
                            sh "ssh root@3.111.51.62 'rm -rf ${serviceName} || true'"
                            sh "ssh root@3.111.51.62 'mkdir ${serviceName}'"

                            // Copy the JAR file to the host
                            sh "cp /var/jenkins_home/workspace/test-microservice/${serviceName}/target/${serviceName}.jar   /root/${serviceName}/${serviceName}.jar"

                            // Copy the Dockerfile to the host
                            sh "cp /var/jenkins_home/workspace/test-microservice/${serviceName}/Dockerfile /root/${serviceName}/"

                            sh "ssh root@3.111.51.62 'docker stop ${serviceName} || true'"
                            sh "ssh root@3.111.51.62 'docker rm ${serviceName} || true'"
                            sh "ssh root@3.111.51.62 'docker rmi ${serviceName} ||true'"
                            sh "ssh root@3.111.51.62 'docker build -t ${serviceName} /root/${serviceName}'"
                            sh "ssh root@3.111.51.62 'docker run -it -d -p ${servicePort}:${servicePort} --name ${serviceName} ${serviceName}'"
                            
                            // Build the Docker image
                            // sh "docker build -t ${serviceName} . --build-arg SERVICE_PORT=${servicePort}"
                        }
                    }
                }
            }
        }
        
        
    }
}
