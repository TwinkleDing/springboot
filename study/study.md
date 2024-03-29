## 多态

### 多态调用成员的特点

1. 成员变量 编译看左边，运行看左边
2. 成员方法 编译看左边，运行看右边

### 多态的优劣

1. 优势：方法中，使用父类型作为参数，可以接受所有子类对象
2. 劣势：不能使用子类的特有共功能，一定要用，要使用强转，使用instanceof关键字判断

## 抽象类

1. 抽象类不能实例化
2. 抽象类中不一定又抽象方法，有抽象方法一定是抽象类
3. 可以有构造方法
4. 抽象类的子类：要么重写抽象类中的抽象方法，要么是抽象类

## 接口

接口可以理解为一种规则，表现一种行为

1. 接口用关键字interface定义 public interface 接口名 {}
2. 接口不能实例化
3. 接口和类之间是实现关系，通过implements关键字表示
4. 接口的子类，要么重写接口中所有的抽象方法，要么是抽象类
5. 接口和类是实现关系，可以单实现，也可以多实现 pub
6. 实现类还可以在继承一个类的同事实现多个接口 public class A extends Aa implements I1, I2 {}

### 接口中成员的特点

1. 成员变量： 只能是常量，默认修饰符 public
2. 构造方法： 没有
3. 成员方法： 之前只能是抽象方法，现在可以有正常方法

## 内部类

1. 内部类表示的事物是外部类的一部分，内部类单独出现没有任何意义
2. 外部类要访问内部类的成员，必须要new一个构造函数
3. 成员内部类： 写在成员位置，属于外部类的成员，可以被装饰符修饰，
4. 静态内部类： 用了static修饰的成员内部类就是静态内部类，静态只能访问静态，直接用类名调用
5. 局部内部类：
    1. 将内部类定义在方法里面就叫局部内部类，类似于方法里面的局部变量
    2. 外界无法直接使用，需要在方法内部创建对象并使用
    3. 该类可以直接访问外部类的成员，也可以访问方法内的局部变量
6. 匿名内部类： 隐藏了名字的内部类

## 数据结构

### 二叉树

#### 平衡二叉树

高度相同，当左右子树高度差超过1时，通过旋转保持平衡

##### 左旋

确定支点，从添加的结点开始，不断地往父节点找不平衡的节点，把支点左旋降级，变成左子节点，晋升原来的右子节点
如果到了根节点，原先的右子节点变成新的父节点，并把多余的左子节点出让，给已经降级的根节点当右子节点

##### 右旋

和左旋刚好相反

1. 左左： 一次右旋
2. 左右： 先将局部左旋，整体右旋
3. 右右： 一次左旋
4. 右左： 先将局部右旋，整体左旋

### 红黑树

是一种特殊的二叉查找树，每一个节点可以是红或黑，红黑树不是高度平衡的，他的平衡时通过红黑规则进行实现的

#### 红黑规则

1. 没有给节点非黑即红
2. 根节点必须是黑色
3. 如果一个节点没有子节点或者父节点，则该节点相应的指针属性值为Nil，这些Nil视为叶节点，每个叶节点是黑色的
4. 如果某一个节点是红色，那么他的子节点必须是黑色（不能出现两个红色节点相连的情况）
5. 对没有给节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点

## stream流

结合lambda表达式，简化集合或数组的操作，

1. 先得到一条stream流，并把数据放上去
2. 利用stream流中的api进行各种操作
3. 中间方法：调用完可以继续调用其他中间方法或者终结方法
4. 终结方法：调用完就结束了

## 多线程

- 线程是操作系统能够进行运算调度的最小单位。它被包含在进程之中，是进程中的实际运作单位。
- 进程是程序的基本执行实体
- 多线程同时让程序干很多事

### 并发于并行

- 并发：在同一时刻，有多个指令在单个CPU上交替执行
- 并行：在同一时刻，有多个指令在多个CPU上同时执行

### 多线程的实现方式

1. 继承Thread类的方式进行实现：将类声明为Thread的子类，该类应重写Thread类的run方法，接下来可以分配并启动该子类的实例。编程简单，可以直接使用Thread类的方法，扩展性较差，不能在继承其他的类
2. 实现Runnable接口：扩展性强，实现该接口的同时还可以继承其他类。但是相对复杂，不能直接使用Thread类中的方法
3. 实现Callable接口：扩展性强，实现该接口的同时还可以继承其他类。但是相对复杂，不能直接使用Thread类中的方法。可以获取多线程的结果

### 常见的成员方法

| 方法名称                                 | 说明                          |
|--------------------------------------|-----------------------------|
| String getName()                     | 返回此线程的名字                    |
| void setName(String name)            | 设置线程的名字，构造方法也可以设置名字         |
| static Thread currentThread()        | 获取当前线程的对象                   |
| static void sleep(long time)         | 让线程休眠指定时间，单位为毫秒             |
| setPriority(int priority)            | 设置线程的优先级                    |
| final int getPriority()              | 获取线程的优先级(默认是5，最大是10，最小是1)   |
| final void setDaemon(boolean daemon) | 设置为守护线程 (其它线程执行完，守护线程陆续结束)  |
| public static void yield()           | 出让线程/礼让线程 (出让CPU执行权，尽可能不执行) |
| public static void join()            | 插入线程/插队线程                   |

### 线程的生命周期

1. 新建状态：创建线程对象
2. 就绪状态：有执行资格，没有执行权
3. 运行状态：有执行资格，有执行权
4. 死亡状态：线程死亡，变成垃圾

- 阻塞状态：没有执行资格，没有执行权，一直在等着，阻塞完成进入就绪状态抢cpu的执行权

### 线程安全问题

1. 同步代码块：synchronized(){}方法，在方法内部，若方法未执行完，外部线程无法抢夺到执行权
2. lock锁：lock.lock()进入锁，lock.unlock()出锁

### 死锁

不要让锁有嵌套关系

### 等待唤醒机制

- void wait()  当前线程等待，直到被其他线程唤醒
- void notify()  随即唤醒单个线程
- void notifyAll()  唤醒所有线程
