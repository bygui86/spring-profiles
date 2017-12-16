#!bin/sh

# Prerequisites:
#	. Java
#	. Gradle
#	. Spring

# Compile with Gradle
./gradlew build

# Run the application for a specific profile:
	# [default] default
	java -jar build/libs/rs-springprofiles-0.1.jar
	# dev
	java -jar -Dspring.profiles.active=dev build/libs/rs-springprofiles-0.1.jar
	# prod
	java -jar -Dspring.profiles.active=prod build/libs/rs-springprofiles-0.1.jar

# In a Unix environment, profiles can also be activated via the environment variable
#	export spring_profiles_active=dev
