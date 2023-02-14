
# 一、项目分工

![image-20230214150005149](http://hhhsir.whuhhh.cn/image-20230214150005149.png)

# 二、模块介绍

现有程序中各个模块：

- netModule：定义了路网在程序中的表达和常规的工具类
  - graph：定义了节点、边和路网图的接口
  - spa：最短路径（程序中用label来表达）
  - util：工具类，定义了路网加载、斐波拉契堆
- dijkstra：实现了最基本的dijkstra算法
- astar：实现了A*算法
- algorithmsTest：进行算法测试
- kVoronoi：实现了kVoronoi算法

程序运行的基础数据：

- roadData：
  - szNetwork.csv：深圳市路网，格式参照```cn.edu.whu.util.networkLoader.LoadNetFromCSV```。
  - xiamenNetwork2.csv：厦门路网，格式参照```cn.edu.whu.util.networkLoader.LoadNetFromCSV。```
  - szSuper：深圳市商超位置，格式参照```pers.hhh.kVoronoi.KVorLoadPOIFromCSV```。
  - ArcMapData：保存了深圳市、厦门市路网的矢量图以及深圳市商超的矢量图。

开发建议：

- 建议阅读现有的netModule、dijkstra两个模块的程序，了解基本的建图及最短路径计算。
- 每个模型创建一个module，自行完成算法编写及测试，完成后提交到github。
- 不要更改上述各个模块的代码（不要改别人的代码），如果netModule模块中定义的结构不能完成相应算法，可自行定义新的结构。
- 建议不要重复造轮子，通过继承、组合netModule中的类可以减少代码量，补充：[IDEA 同一个工程下不同模块之间的类相互调用](https://blog.csdn.net/big_data1/article/details/81218006)。



