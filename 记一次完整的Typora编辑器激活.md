# 记一次完整的Typora编辑器激活


​	首先跟大家简单介绍一下Typora：Typora是一个功能强大的支持MarkDown语法的编辑器，

使用起来非常优雅简单，我个人很喜欢用。但是最近Typora开始收费了，一定程度上影响了

使用，为此特意写了这篇文章记录一下。特此强调，有条件的一定要支持正版。

下面是激活教程：

一、其实完全可以直接利用现成的Typora激活码进行激活的：

Email:

crack@example.com

序列号(以下任选一种)：

9CJ4WE-LSRSHE-HHAHSV-4YWYPS

4VGZU7-LF9LES-4ACUFK-NFN2GA

QDV87M-XFZY9T-HSNPSV-WCNCZS

二、下面记录Typora获取激活码的完整过程：

1、为了破解需要，首先需要预装各种环境和工具，如：git、python环境、nodejs，

这些其实都可以直接通过电脑上的电脑管家中的软件管理进行搜索安装。省去从网上找资源的麻烦。

2、升级pip到最新版本，待会我们需要用到pip：

快捷键：win + R 打开 运行窗口，输入 cmd 进入到dos界面，然后输入：

python -m pip install --upgrade pip -i https://pypi.douban.com/simple

3、从github上克隆我们需要的脚本文件：

git clone https://github.com/Mas0nShi/typoraCracker.git

4、通过pip安装依赖：

注意先进入刚下载的git项目typoraCracker目录内，然后再调用pip命令进行下载：

进入dos窗口后，我们可以cd切换到typoraCracker目录，然后再调用pip下载：

pip install -r requirements.txt -i https://pypi.tuna.tsinghua.edu.cn/simple/

5、执行解包命名：

python typora.py "C:\AMy\Typora\resources\app.asar" .

其中C:\AMy\Typora\resources\app.asar为你自己电脑上Typora安装的目录路径，需替换。

6、替换License.js文件：

用typoraCracker目录内的 example\path\License.js替换掉dec_app\License.js文件

7、重新打包生成app.asar文件：

python typora.py -u ./dec_app/ .

8、将typoraCracker文件夹内的app.asar文件替换掉Typora\resources目录下的app.asar文件。

9、利用nodejs生成序列号，执行成功后控制台会打印出序列号：

node ./example/keygen.js

10、激活Typora：

打开Typora界面后，点击右下方的激活按钮，依次输入邮箱：crack@example.com

输入序列号：刚控制台答应的序列号，直接复制粘贴过来就好

最后点击激活。

三、注意事项：

1、第二步中分别用到了git、python、nodejs等，注意配置系统环境变量，这样可以在不同目录中直接访问调用。

2、使用git下载项目时，有时会因网络问题导致超时，从而下载失败。我们可以改用国内镜像进行下载，这样下载速度会很快，具体用法是在完整的git clone 指令后，再加上 -i 参数，最后再跟国内某个镜像，如清华的https://pypi.douban.com/simple镜像，具体使用可参考第二步中的2或者4。

3、注意执行pip下载时的相对路径，如第二步4中必须先进到typoraCracker目录，再调用pip进行下载。否则的话会提示找不到相关文件，从而下载失败。

四、最后：

本文参考了https://www.cnblogs.com/HGNET/p/15836188.html、https://www.cnblogs.com/LiuDanK/articles/15638323.html这两篇文章，但是按照他们的方法生成序列号遇到了一些困难，花了比较长的时间才把序列号生成出来。原因就是我第三步中提到的细节注意事项部分。
