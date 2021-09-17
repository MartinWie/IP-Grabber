if mvn clean install -DskipTests ; then 
    echo "Compile succeeded."
else
    exit 1
fi

if mvn surefire:test ; then 
    echo "Tests succeeded."
else
    exit 1
fi

date "+%Y-%m-%dT%H:%M:%S"
echo "Pushing to main."
git push

