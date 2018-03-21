# cors-test
学习跨域问题的测试代码

domain-a 项目为调用方

domain-b 项目为被调用方

clone 代码后，启动两个项目，访问：http://localhost:8080/index (domain-a项目)


testNginx 和 bServerTest1 测试接口需要本地有 nginx 服务，配置可以用项目中的 nginx.conf 文件。
（需要修改host 把域名指到本地）