StatusUIManager:  界面状态管理（loading，数据空，服务器出错，网络出错，数据解析出错....）
===================================================


demo：

![](doc/11.png)

=============================

截图：

![](doc/22.gif)

==============================

## 1 这是什么？
* 此乃何物
    * 一个页面从开始请求数据到请求有了结果之后，有多种状态UI切换
    * 这个小library就是让你方便的控制这些状态的显示样式，显示和隐藏
    * 并且所有状态和UI都是可配置的
    * 并且不侵入你原始的布局，完全以组件的形式提供
    * 并且要求低，只要求你的content view外面包一层FrameLayout
    * 并且使用简单，你只需要定义自己的status和显示样式，并且还内置了几个常见的状态和布局

## 2 怎么用？

### 1 状态定制，默认的状态在DefaultStatus里

```java
public class Default {
     public static final int LOADING = 0;
     public static final int EMPTY = 1;
     public static final int NET_OFF = 2;
     public static final int SERVER_ERROR = 3;
     public static final int LOGIC_FAIL = 4;
     public static final int LOCAL_ERROR = 5;
}

反正就是个字符串常量，你在哪儿都可以自己定义

```

### 2 给各个状态配置不同UI，对应默认状态的UI都在DefaultStatusProvider


```java
//Default.LOADING：正在加载
DefaultStatusProvider.DefaultLoadingStatusView

///Default.EMPTY：数据为空，一般用在列表页
DefaultStatusProvider.DefaultEmptyStatusView

//Default.NETOFF：没网了
DefaultStatusProvider.DefaultNetOffStatusView

//Default.SERVER_ERROR： 服务器出问题了，生产环境是可能出这个问题的
DefaultStatusProvider.DefaultServerErrorStatusView

//Default.LOGIC_FAIL：请求本身没有问题，但业务逻辑有问题，例如注册用户时，用户名重复，一般都会带个业务code
DefaultStatusProvider.DefaultLogicFailStatusView

//Default.LOCAL_ERROR：请求本身没有问题，但处理数据时出异常了，虽然是手机端代码的问题，但大多数是服务器json给的不规范
DefaultStatusProvider.DefaultLocalErrorStatusView
```

StatusProvider到底怎么回事？
```java
StatusProvider(int status, View contentView, OnStatusViewCreateCallback callback)
状态UI提供器

参数1：对应哪个status
参数2：内容View，即正常数据的View，必须包在一个FrameLayout里
参数3：callback，状态UI初始化之后，可以做一些样式设置，事件设置等
```

### 3 控制显示状态UI和内容UI

```java
statusUIManager.show(int status) //显示对应状态UI
statusUIManager.clearStatus()   //显示内容UI

statusUIManager里其实是一个map，存储了所有你设置的StatusProvider
```

```java
一般代码如下：
private void initStatusUI() {
        statusUIManager = new StatusUIManager();

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLoadingStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultEmptyStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultServerErrorStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLogicFailStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {
                                
                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultNetOffStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

        statusUIManager.addStatusProvider(
                new DefaultStatusProvider.DefaultLocalErrorStatusView(
                        contentView,
                        new StatusProvider.OnStatusViewCreateCallback() {
                            @Override
                            public void onCreate(int status, View statusView) {

                            }
                        }));

    }


```

