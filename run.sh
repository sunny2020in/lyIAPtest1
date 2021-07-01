#!/bin/bash


##打开Appium并 后台运行&
#node /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js &
#清空上次测试结果
rm -r allure-results
rm -r allure-report
#运行testng.xml 进行测试
mvn clean test -DsuiteXmlFile=testng.xml
sleep 3
##把第二个赋值   grep -v是排除
#pid=$(ps -ef | grep 'appium/build/lib/main.js' | grep -v grep | awk '{print $2}')
##   -9安全操作
#kill -9 $pid
#直接打开测试报告
allure serve allure-results

##生成 index.html 文件，消息通知——去钉钉查看官网文档格式
#allure generate allure-results -o allure-report
##钉钉机器人地址
#curl 'https://oapi.dingtalk.com/robot/send?access_token=81d0b6f507946ac7216a513cb7a67df798acf496d5d7d80a9fc1a054465a96dc' \
#  -H 'Content-Type: application/json' \
#  -d '{
#      "msgtype": "markdown",
#      "markdown": {
#      "title":"API 自动化",
#      "text": "API 自动化执行完成,请及时查看[测试报告](http://192.168.100.164:8080)"
#             }
#        }'


#
##定时跑，并发送消息到钉钉，测试报告通过index.html查看
##环境变量
#source /etc/profile
#source ~/.bash_profile
#
#time=$(date "+%Y-%m-%d %H:%M:%S")
#echo "${time}"
#
#cd  /Users/xmly/Downloads/AndroidUItest
#
#node /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js &
#rm -r allure-results
#rm -r allure-report
#mvn clean test -DsuiteXmlFile=testng.xml
#sleep 3
#pid=$(ps -ef | grep 'appium/build/lib/main.js' | grep -v grep | awk '{print $2}')
#kill -9 $pid
#
#allure generate allure-results -o allure-report
#
#curl 'https://oapi.dingtalk.com/robot/send?access_token=81d0b6f507946ac7216a513cb7a67df798acf496d5d7d80a9fc1a054465a96dc' \
#  -H 'Content-Type: application/json' \
#  -d '{
#      "msgtype": "markdown",
#      "markdown": {
#      "title":"API 自动化",
#      "text": "API 自动化执行完成,请及时查看[测试报告](http://192.168.100.164:8080)"
#             }
#        }'
