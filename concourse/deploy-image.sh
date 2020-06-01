#!/bin/bash

set -e -u -x

# handle_error() {
#     echo "${0##*/}: Error occurred on line $1"
#     exit 1
# }

# trap 'handle_error $LINENO' ERR

# echo "-------------------------------------------------"
# echo "       Running ${0##*/}"
# echo "-------------------------------------------------"

# echo "-------------------------------------------------"
# echo "       Building and Testing"
# echo "-------------------------------------------------"

# if [ -n "$1" ]
# then
# ./mvnw versions:set -DnewVersion=$1
# fi

# ./mvnw clean package

# ./mvnw clean package

./mvnw package -Dmaven.repo.local=.m2
#cp target/*.jar workspace/todo-services.jar

# put the image in docker local registry