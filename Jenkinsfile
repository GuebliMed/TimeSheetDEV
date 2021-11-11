pipeline {
  environment{
	registry = "24339824/devopsimage"
	registryCredential= 'dockerHub'
	dockerImage = ''
 
 }
 agent any
 stages{
  stage('Checkout GIT'){
    steps{
      echo 'Pulling...';
      git branch: 'NaderBranch',
      url : 'https://github.com/GuebliMed/TimeSheetDEV.git';
    }
  }
         

  stage("Test,Build"){
    steps{
      bat """mvn clean package"""
    }
     }


  stage("Sonar"){
    steps{
      bat """mvn sonar:sonar"""
    }
     }

          
  stage("Nexus"){
    steps{
      bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.jar"""
    }
     }
         
  stage('Building our image') {
    steps {
       script {
          dockerImage= docker.build registry + ":$BUILD_NUMBER" 
       }
    }
  }

  stage('Deploy our image') {
    steps {
       script {
         docker.withRegistry( '', registryCredential) {
            dockerImage.push() 
         }
       } 
    }
  }

  stage('Cleaning up') {
    steps { 
      bat "docker rmi $registry:$BUILD_NUMBER" 
    }
  }
}

post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'nader9hajji@gmail.com'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'nader9hajji@gmail.com'
		}
}

}