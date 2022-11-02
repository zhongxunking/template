# 模板工程介绍

创建项目命令模板：

    mvn archetype:generate -DarchetypeGroupId=org.antframework.template -DarchetypeArtifactId=template-archetype -DarchetypeVersion=1.0.0.RELEASE -DgroupId="被创建项目的groupId" -DartifactId="被创建项目的artifactId" -Dversion="被创建项目的版本号"

参数说明：

    -DgroupId 指定被创建项目的groupId
    -DartifactId 指定项目名
    -Dversion 指定项目版本号
    
例如：
```shell
mvn archetype:generate -DarchetypeGroupId=org.antframework.template -DarchetypeArtifactId=template-archetype -DarchetypeVersion=1.0.0.RELEASE -DgroupId=org.antframework.demo -DartifactId=demo -Dversion=1.0-SNAPSHOT
```

## 各模块介绍
各模块依赖关系： 
- test --> assembly --> web --> biz --> dal --> facade
- dal --> common
- biz  --> integration --> common

以下介绍每个模块的作用，从底层模块到高层模块顺序介绍：

### 1. template-facade
facade层，本模块是本系统对上层系统的api，是设计模式的【门面模式】，遵从设计模式的【最少知识原则】，对外屏蔽内部实现细节。
> 我们一些系统提供出去的接口就像insertXXX、updateXXX这样，入参呢就是表对应的实体（PO）， 这样提供出去的根本就不是服务，更像是把自己系统的mapper提供出去了，这样会导致系统的业务价值极低，系统更像是一个存储单元，而没有自己的业务逻辑，这样会导致本该属于本系统的业务逻辑，却出现在了上层系统中，而上层系统则会去关心底层系统的实现，导致上层系统越来越臃肿，可读性、可维护性越来越差。所以设计好本系统对上层系统的api是关键，把本系统不该暴露出去的细节，坚决不暴露出去。

### 2. template-common
公共层，本模块存放项目公共性的工具和公共性的依赖

### 3. template-dal
数据访问层，dal即是Data Access Layer，所有对数据库的访问操作均是通过本层进行，比如mybatis、jpa操作的DAO都应该定义在这个模块，好处就是方便维护，比如以后要更换ORM框架，则只需要改动这层代码就行，其他代码几乎不用动。

### 4. template-integration
集成层，需要调用其他系统的服务在本模块编写。一个系统不光会被其他系统调用，它还可能会调用其他系统，那么调用其他的系统的代码应该集中在这一层，好处就是在这层统一管理对其他系统的调用，本系统依赖了哪些系统的哪些服务，可以一目了然在这层看出，便于维护。需要调用的其他系统的facade在本模块引入。

### 5. template-biz
biz层，biz是Business的谐音缩写，即是业务逻辑层。本层实现template-facade提供出去的接口，它是一个系统的重中之重，主要的业务逻辑都是在这层实现。

### 6. template-web
web层，处理与网页相关的逻辑。而且web层只应该处理网页相关的逻辑，比如操作session、权限校验、用户页面输入的参数处理、返回结果展示。而业务逻辑处理不应该放在web层，而应该放在biz层，web层应该通过调用facade层的api提供出来的服务间接调用biz层，来达到业务处理目的，这样做的好处就是web层和biz层进行了解耦。
> 不知你有没有这种体验：由于需求变更给用户展示的页面需要修改，导致系统内部一大片需要跟着改，这就是web层和biz层耦合太深了，导致牵一发而动全身，而且页面这种直接和用户交互的东西是最容易会发生变化的，所以我们应该独立出web层，将这种易变性从我们的核心biz层剥离出来。

### 7. template-assembly
装配层，本模块会聚合本系统的其他模块组装成最终的执行程序（jar包或war包）。同时本模块还提供环境相关配置，比如各种properties、yaml文件。

### 8. template-test
测试层，所有模块的单元测试代码应该写在本模块中，好处就是将测试代码从其他模块隔离出来，便于查看和管理；消除其他模块pom对测试的依赖，净化pom；本模块有其他所有模块的依赖，也便于单元测试。
