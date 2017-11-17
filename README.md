# template

创建项目命令模板：

    mvn archetype:generate -DarchetypeGroupId=org.antframework.template -DarchetypeArtifactId=template-archetype -DarchetypeVersion=1.0.0.RELEASE -DgroupId="被创建项目的groupId" -DartifactId="被创建项目的artifactId" -Dversion="被创建项目的版本号"

参数说明：

    -DgroupId 指定被创建项目的groupId
    -DartifactId 指定项目名
    -Dversion 指定项目版本号
    
例如：

    mvn archetype:generate -DarchetypeGroupId=org.antframework.template -DarchetypeArtifactId=template-archetype -DarchetypeVersion=1.0.0.RELEASE -DgroupId=org.antframework.demo -DartifactId=demo -Dversion=1.0-SNAPSHOT
    

