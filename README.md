JAVA SDK 

API文档请访问:
https://github.com/vcbCom/vcbApi/wiki

相关操作:com.vcb.service.ApiVcbService


使用方法:
1.使用maven package 后会生成如下三个jar包 
    vcb-java-sdk-1.0.jar
    vcb-java-sdk-1.0-sources.jar(源码包) 
    vcb-java-sdk-1.0-jar-with-dependencies.jar(带依赖的jar:避免与您项目依赖jar版本差异而无法运行的情况)
2.将jar包放在您项目libs目录下,maven 中添加如下内容:
```
   <dependency>
      <groupId>com.vcb</groupId>
      <artifactId>vcb-java-sdk</artifactId>
      <version>1.0</version>
      <scope>system</scope>
      <systemPath>${project.basedir}/libs/vcb-java-sdk-1.0.jar</systemPath>
      <!--<systemPath>${project.basedir}/libs/vcb-java-sdk-1.0-jar-with-dependencies.jar</systemPath>-->
     </dependency>
```
3.创建相应的service:
```
     private static ApiVcbService apiVcbService = new ApiVcbService("ivpdru4c-qpdqswld-yx9atr8t-t7763","89j2t90o-76fhxpc2-3vz0fh18-j2471","http://vcb.tzld.com")
```