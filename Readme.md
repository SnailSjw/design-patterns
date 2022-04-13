书籍《Java设计模式》-刘伟
## 面向对象设计原则

软件的可维护性（Maintainability）和可复用性（Reusability）是两个非常重要的用于衡量软件质量的属性，软件的可维护性是指软件能够被理解、改正、适应及扩展的难易程度，软件的可复用性是指软件能够被重复使用的难易程度。

| 设计原则名称                                         | 定义                                                         |
| ---------------------------------------------------- | ------------------------------------------------------------ |
| 单一职责原则（Single Responsibility Principle，SRP） | 一个对象应该只包含单一的职责，并且该职责被完整地封装在一个类中 |
| 开闭原则（Open-Closed Principle，OCP）               | 软件实体应当对扩展开放，对修改关闭                           |
| 里氏代换原则（Liskov Substitution Principle，LSP）   | 所有引用基类的地方必须能透明地使用其子类的对象               |
| 依赖倒转原则（Dependence Inversion Principle，DIP）  | 高层模块不应该依赖低层模块，它们都应该依赖抽象。抽象不应该依赖于细节，细节应该依赖于抽象 |
| 接口隔离原则（Interface Segregation Principle，ISP） | 客户端不应该依赖那些它不需要的接口                           |
| 合成复用原则（Composite Reuse Principle，CRP）       | 优先使用对象组合，而不是通过继承来达到复用的目的             |
| 迪米特法则（Law of Demeter，LoD）                    | 每一个软件单位对其他单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位 |








## 简单工厂模式

>简单工厂模式（Simple Factory Pattern）：定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。  

由于 简单工厂模式中用于创建实例的方法通常都是静态方法，因此简单工厂模式又被称为静态工厂(Static Factory Method)模式，它是一种创建型模式。

### 简单工厂模式结构

1. Factory（工厂角色）：又叫做工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑。对外提供静态的工厂方法，返回值类型为抽象类类型。
2. Product（抽象产品角色）：工厂类创建的所有对象的父类，封装了各种产品对象的公有方法。
3. ConcreteProduct（具体产品角色）：简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体的实例。它需要实现抽象产品角色的抽象方法。

![image-20220329222845689](https://gitee.com/snailjw/article-images/raw/master/typora/202203311134887.png)

### 创建对象与使用对象

Java中通常有以下几种创建对象的方式：

* 使用new关键字直接创建对象
* 通过反射机制创建对象
* 通过克隆方法创建对象
* 通过工厂类创建对象

工厂是强调：两个类A和B之间的关系应该仅仅是A创建B或者A使用B，而不能两种关系都有。

创建和使用分离可以防止用来实例化一个类的数据和代码在多个类中到处都是，可以将有关创建的知识搬移到一个工厂类中。但并不是需要为系统中的每个类都配置一个工厂类，如果一个类很简单，而且不存在太多变化，其构造过程也很简单，此时就无需为其提供工厂类，直接在使用之前实例化即可。

### 简单工厂模式优/缺点与适用环境

#### 简单工厂模式优点：

优点主要有如下：

1. 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分离。
2. 客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以在一定程度上减少使用者的记忆量。
3. 通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。

#### 简单工厂模式缺点

缺点主要有如下：

1. 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
2. 使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
3. 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
4. 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。

#### 简单工厂模式适用环境

在以下情况下可以考虑使用简单工厂模式：

* 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
* 客户端只知道传人工厂类的参数，对于如何创建对象并不关心。

## 工厂方法模式

工厂方法模式是简单工厂模式的延伸，它继承了简单工厂模式的优点，同时还弥补了简单工厂模式的缺陷，更好的符合开闭原则的要求，在增加新的具体产品对象时不需要对已有的系统做任何修改。

### 工厂方法模式概述

简单工厂模式如果要新增一个具体的产品需要修改工厂类的代码，这在一定程度上违反了开闭原则。在工厂方法模式中不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，系统提供一个与产品等级结构对应的工厂等级结构。

工厂方法模式的定义：

> 定义一个用于创建对象的接口，但是让子类决定将哪个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

关于定义有如下说明：

* 简称为**工厂模式(Factory Pattern)**

* 又可称作**虚拟构造器模式(Virtual Constructor Pattern)**或**多态工厂模式(Polymorphic Factory Pattern)**

* **工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象。**

* 目的是**将产品类的实例化操作延迟到工厂子类中完成**，即**通过工厂子类来确定究竟应该实例化哪一个具体产品类。**

### 工厂方法模式结构与实现

#### 工厂方法模式结构

工厂方法模式的结构如图：

![image-20220330124911882](https://gitee.com/snailjw/article-images/raw/master/typora/202203311134376.png)

工厂方法模式包含4个角色：

1. **Product（抽象产品）：**它是定义产品的接口，是工厂方法模式所创建对象的超类型，也就是产品对象的公共父类。
2. **ConcreteProduct（具体产品）：**它实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，具体工厂和具体产品直接一一对应。
3. **Factory（抽象工厂）：**在抽象工厂类中声明了工厂方法（Factory Method），用于返回一个产品。抽象工厂是工厂方法模式的核心，所有创建对象的工厂类都必须实现该接口。
4. **ConcreteFactory(具体工厂)：**它是抽象工厂类的子类，它实现了在抽象工厂中申明的工厂方法，并可由客户端调用，返回一个具体产品类的实例。

#### 工厂方法模式实现

与简单工厂模式相比，工厂方法模式最重要的特点是引入了抽象工厂角色，抽象工厂可以是接口，也可以是抽象类或者具体类。

典型代码如下：

```java
public interface Factory{
    public Product factoryMethod();
}
```

具体对象的创建由工厂子类负责，客户端针对抽象工厂编程，可在运行时指定具体工厂类，具体工厂类实现了工厂方法，不同的具体工厂可以创建不同的具体产品。

```java
public class ConcreteFactory implement Factory{
    @Override
    public Product factoryMethod(){
        return new ConcreteProduct();
    }
}
```

典型的客户端代码如：

```java
		……
		Factory factory = new ConcreteFactory(); 
		// 通过配置文件与反射机制实现
		// Factory factory = (Factory) XMLUtil.getBean("concreteProduct");
        Product product = factory.factoryMethod();
        product.someMethod();
		……
```

### 工厂方法模式应用实例

**实例说明：**

某系统运行日志记录器(Logger)可以通过多种途径保存系统的运行日志，例如通过文件记录或数据库记录，用户可以通过修改配置文件灵活地更换日志记录方式。在设计各类日志记录器时，开发人员发现需要对日志记录器进行一些初始化工作，初始化参数的设置过程较为复杂，而且某些参数的设置有严格的先后次序，否则可能会发生记录失败。

为了更好地封装记录器的初始化过程并保证多种记录器切换的灵活性，现使用工厂方法模式设计该系统。

**实例类图：**

![image-20220330220150017](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135205.png)



具体代码实现参考项目代码：`factory-method-pattern`

### 工厂方法模式的重载

在某些情况下，可以提供一组重载的工厂方法，以不同的方式对产品对象进行创建。但是对于同一个具体工厂而言，无论使用哪个工厂方法，所创建的产品类型均要相同。重载的工厂方法结构图如下：

![image-20220330140550674](.\images\image-20220330140550674.png)

在抽象工厂中声明了多个重载的工厂方法，在具体工厂中实现这些工厂方法，这些方法可以包含不同的业务逻辑，以满足产品对象的多样化创建需求。

### 工厂方法的隐藏

**目的：**为了进一步简化客户端的使用

**实现：**在工厂类中直接调用产品类的业务方法，客户端无须调用工厂方法创建产品对象，**直接使用工厂对象即可调用所创建的产品对象中的业务方法。**

![image-20220330220412834](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135388.png)

`LoggerFactory`代码修改如下：

```java
public interface LoggerFactory {
    /**
     * 创建日志
     * @return 日志抽象类
     */
    public Logger createLogger();

    /**
     * 在工厂中实现写日志的逻辑
     */
    public default void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
```

客户端代码：

```java
public class Client {
    public static void main(String[] args) {
        // 此处注意bean.xml配置文件中的class中配置的具体类以免出错。
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("fileLogger");
        //此处直接用过工厂调用，而不是具体的客户端
        factory.writeLog();
    }
}
```

### 工厂方法模式优/缺点与使用环境

#### 工厂方法模式优点：

1. 工厂方法用来创建客户所需要的产品，同时还**向客户隐藏了哪种具体产品类将被实例化这一细节**。
2. 能够**让工厂自主确定创建何种产品对象**，而如何创建这个对象的细节则完全封装在具体工厂内部。
3. 在系统中加入新产品时，**完全符合开闭原则**。

#### 工厂方法模式缺点

1. 系统中**类的个数将成对增加**，在一定程度上增加了系统的复杂度，会给系统带来一些额外的开销。
2. **增加了系统的抽象性和理解难度。**

#### 工厂方法模式适用环境

在以下情况可以考虑使用工厂方法模式：

1. **客户端不知道它所需要的对象的类**（客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体产品对象由具体工厂类创建）。
2. **抽象工厂类通过其子类来指定创建哪个对象。**

## 抽象工厂模式

### 产品等级结构与产品族

1. **产品等级结构：** **产品等级结构即产品的继承结构**，如：一个抽象类是电视机，其子类包括海尔电视，海信电视，TCL电视，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机试其子类。
2. **产品族：**在抽象工厂模式中，**产品族是指由同一个工厂生产的位于不同产品等级结构中的一组产品。**如下图示：

![image-20220330203354559](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135957.png)

### 抽象工厂模式概述

**模式动机：**

* 当系统所提供的工厂生产的具体产品并不是一个简单的对象，而是多个位于不同产品等级结构、属于不同类型的具体产品时就可以使用抽象工厂模式。
* 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形式。

**抽象工厂模式的定义：**

> **抽象工厂模式：**提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。

关于定义的说明：

* 抽象工厂模式属于**对象创建型模式**。
* 又称为工具（kit）模式
* 抽象工厂模式中的具体工厂不只是创建一种产品，它负责创建一族产品。
* 当一个工厂等级结构可以创建出分属于不同产品等级结构的一个产品族中的所有对象时，抽象工厂模式比工厂方法模式更为简单、更有效率。

### 抽象工厂模式结构与实现

#### 抽象工厂模式结构

抽象工厂模式结构如图示：

![image-20220330213008648](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135682.png)

**抽象工厂模式的结构：**

抽象工厂模式包含以下4个角色：

* **AbstractFactory（抽象工厂）：**它声明了一组用户创建一族产品的方法，每一个方法对应一种产品。
* **ConcreteFactory（具体工厂）：**它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。
* **AbstractProduct（抽象产品）：**它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。
* **ConcreteProduct（具体产品）：**它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。

#### 抽象工厂模式实现

典型的抽象工厂类代码：

```java
public interface AbstractFactory {
    public AbstractProductA createProductA(); //工厂方法一
    public AbstractProductB createProductB(); //工厂方法二
    ……
}
```

典型的具体工厂类代码：

```java
public class ConcreteFactory1 implements AbstractFactory {
    //工厂方法一
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }
    //工厂方法二
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
    ……
}
```

### 抽象工厂模式应用实例：

某软件公司要开发一套界面皮肤库，可以对基于Java的桌面软件进行界面美化。用户在使用时可以通过菜单来选择皮肤，不同的皮肤将提供视觉效果不同的按钮、文本框、组合框等界面元素，例如春天(Spring)风格的皮肤将提供浅绿色的按钮、绿色边框的文本框和绿色边框的组合框，而夏天(Summer)风格的皮肤则提供浅蓝色的按钮、蓝色边框的文本框和蓝色边框的组合框，其结构示意图如下图所示：

![image-20220330213743595](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135711.png)

根据如上描述，结构图如下：

![image-20220330213846205](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135014.png)

具体代码实现参看项目模块：`abstract-factory-pattern`

### 开闭性原则的倾斜性

在抽象工厂模式中**增加**新的**产品族**很**方便**，但是**增加**新的**产品等级结构**很**麻烦**，抽象工厂模式的这种性质称为**开闭原则的倾斜性**。

* **增加产品族：**

  **对于增加新的产品族**，抽象工厂模式很好地**支持**了**开闭原则**，只需要增加具体产品并对应增加一个新的具体工厂，对已有代码无需做任何修改。

* **增加新的产品等级结构：**

  **对于增加新的产品等级结构**，需要修改所有的工厂角色，包括抽象工厂类，在所有的工厂类中都需要增加生产新产品的方法，**违背了开闭原则**。

正因为以上原则，因此要求设计人员在设计之初就能够考虑全面，不会在设计完成之后再向系统中增加新的产品等级结构，也不会删除已有的产品等级结构。

### 抽象工厂模式的优缺点与适用环境

#### 模式优点

1. **隔离了具体类的生成**，使得客户端并不需要知道什么被创建。
2. 当一个产品族中的多个对象被设计成一起工作时，它**能够保证客户端始终只使用同一个产品族中的对象。**
3. **增加新的产品族很方便**，无须修改已有系统，**符合开闭原则**。

#### 模式缺点

1. **增加新的产品等级结构麻烦**，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，这显然会带来较大的不便，**违背了开闭原则**。

#### 模式适用环境

1. 一个系统**不应当依赖于产品类实例如何被创建、组合和表达的细节**。
2. 系统中有多于一个的产品族，但**每次只使用其中某一产品族**。
3. **属于同一个产品族的产品将在一起使用**，这一约束必须在系统的设计中体现出来。
4. **产品等级结构稳定**，在设计完成之后不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。

### 本章小结

1. 在抽象工厂模式中，产品等级结构即产品的继承结构，产品族是指由同一个工厂生产的位于不同产品等级结构中的一组产品。
2. 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式是一种对象创建型模式。
3. 抽象工厂模式包含抽象工厂、具体工厂、抽象产品和具体产品4个角色。其中，抽象工厂声明了一组用于创建一族产品的方法，每一个方法对应一种产品；具体工厂实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；抽象产品为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法；具体产品定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。
4. 抽象工厂模式的优点主要是隔离了具体类的生成，使得客户端并不需要知道什么被创建；当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象；增加新的产品族很方便，无须修改已有系统，符合开闭原则。其缺点主要是增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，违背了开闭原则
5. 抽象工厂模式适用于以下环境：一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节；系统中有多于一个的产品族，而每次只使用其中某一产品族；属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来；产品等级结构稳定，在设计完成之后不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。
6. 抽象工厂模式以一种倾斜的方式来满足开闭原则。对于增加新的产品族，抽象工厂模式很好地支持了开闭原则；对于增加新的产品等级结构，需要修改所有的工厂角色，违背了开闭原则。

## 建造者模式

### 建造者模式概述

建造者模式可以将部件本身和它们的组装过程分开，关注如何一步步创建一个包含多个组成部分的复杂对象，用户只需要指定复杂对象的类型即可得到该对象，而无须知道其内部的具体构造细节。

> 建造者模式：将一个复杂对象的构建与它的标识分离，是的同样的构建过程可以创建不同的表示。

建造者模式属于*对象创建型*模式

关于定义的说明：

* 将客户端与包含多个部件的复杂对象的创建过程分离。**客户端无需知道复杂对象的内部组成部分与装配方式**，只需要知道所需建造者的类型即可。
* **关注如何逐步创建一个复杂的对象**，不同的建造者定义了不同的创建过程。

### 建造者模式的结构与实现

#### 建造者模式的结构：

![image-20220411231810866](https://gitee.com/snailjw/article-images/raw/master/typora/202204112318935.png)

#### 建造者模式包含的角色：

* Builder（抽象建造者）
* ConcreteBuilder（具体建造者）
* Product（产品）
* Director（指挥者）

#### 建造者模式的实现

典型的复杂对象类代码：

```java
public class Product {
    private String partA;
    private String partB;
    private String partC;
    //partA的Getter方法和Setter方法省略
	//partB的Getter方法和Setter方法省略
	//partC的Getter方法和Setter方法省略
}
```

典型的抽象建造者类代码：

```java
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    
    //返回产品对象
    public Product getResult(){
        return product;
    }
}
```

典型的具体建造者类代码：

```java
public class ConcreteBuilder1 extends Builder {
	public void buildPartA() {
        product.setPartA("A1");
    }

    public void buildPartB() {
        product.setPartB("B1");
    }

    public void buildPartC() {
        product.setPartC("C1");
    }
}
```

典型的指挥者类代码：

```java
public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
```

客户类代码片段：

```java
	……
    Builder builder = new ConcreteBuilder1(); //可通过配置文件实现
	Director director = new Director(builder);
	Product product = director.construct();
    ……
```

### 建造者模式的应用实例

实例说明：

> 某游戏软件公司决定开发一款基于角色扮演的多人在线网络游戏，玩家可以在游戏中扮演虚拟世界中的一个特定角色，角色根据不同的游戏情节和统计数据（例如力量、魔法、技能等）具有不同的能力，角色也会随着不断升级而拥有更加强大的能力。
>
> 作为该游戏的一个重要组成部分，需要对游戏角色进行设计，而且随着该游戏的升级将不断增加新的角色。通过分析发现，游戏角色是一个复杂对象，它包含性别、面容等多个组成部分，不同类型的游戏角色，其性别、面容、服装、发型等外部特性都有所差异，例如“天使”拥有美丽的面容和披肩的长发，并身穿一袭白裙；而“恶魔”极其丑陋，留着光头并穿一件刺眼的黑衣。
>
> 无论是何种造型的游戏角色，它的创建步骤都大同小异，都需要逐步创建其组成部分，再将各组成部分装配成一个完整的游戏角色。现使用建造者模式来实现游戏角色的创建。

实例类图：

![image-20220412220455599](https://gitee.com/snailjw/article-images/raw/master/typora/202204122204664.png)

实例代码：

**(1) Actor**：游戏角色类，充当复杂产品对象

**(2)** **ActorBuilder**：游戏角色建造者，充当抽象建造者

**(3)** **HeroBuilder**：英雄角色建造者，充当具体建造者

**(4)** **AngelBuilder**：天使角色建造者，充当具体建造者

**(5)** **DevilBuilder**：恶魔角色建造者，充当具体建造者

**(6)** **ActorController**：角色控制器，充当指挥者

**(7) Client**：客户端测试类

### 指挥者类的深入讨论

1. 省略Director（省略指挥者类）

  * 可以将**指挥者**类的逻辑在**抽象建造者**中实现

    ```java
    public abstract class ActorBuilder {
        protected static Actor actor = new Actor();
        
        public abstract void buildType();
        public abstract void buildSex();
        public abstract void buildFace();
        public abstract void buildCostume();
        public abstract void buildHairstyle();
     
        //增加该方法(该方法原本在指挥者类中)
        public static Actor construct(ActorBuilder ab) {
            ab.buildType();
            ab.buildSex();
            ab.buildFace();
            ab.buildCostume();
            ab.buildHairstyle();
            return actor;
        }
    }
    ```

    Client中调用改为：

    ```java
        ……
        ActorBuilder ab;
        ab = (ActorBuilder)XMLUtil.getBean();
    
        Actor actor;
        actor = ActorBuilder.construct(ab);
        ……
    ```

  * 将construct方法中的参数去掉，直接在construct()方法中调用buildPartX()方法。

    ```java
    public abstract class ActorBuilder {
        protected Actor actor = new Actor();
        
        public abstract void buildType();
        public abstract void buildSex();
        public abstract void buildFace();
        public abstract void buildCostume();
        public abstract void buildHairstyle();
    
        public Actor construct() {
            this.buildType();
            this.buildSex();
            this.buildFace();
            this.buildCostume();
            this.buildHairstyle();
            return actor;
        }
    }
    ```

    Client中调用改为：

    ```java
        ……
        ActorBuilder ab;
        ab = (ActorBuilder)XMLUtil.getBean();
    
        Actor actor;
        actor = ab.construct();
        ……
    ```

2. 钩子方法的引入

  * 钩子方法(Hook Method)：返回类型通常boolean类型，方法名一般为isXXX()

    ```java
    public abstract class ActorBuilder {
        protected Actor actor = new Actor();
        
        public abstract void buildType();
        public abstract void buildSex();
        public abstract void buildFace();
        public abstract void buildCostume();
        public abstract void buildHairstyle();
        
        //钩子方法
        public boolean isBareheaded() {
            return false;
        }
        
        public Actor createActor() {
            return actor;
        }
    }
    
    ```

    ```java
    public class DevilBuilder extends ActorBuilder {
        public void buildType() {
            actor.setType("恶魔");
        }
    
        public void buildSex() {
            actor.setSex("妖");
        }
    
        public void buildFace() {
            actor.setFace("丑陋");
        }
    
        public void buildCostume() {
            actor.setCostume("黑衣");
        }
    
        public void buildHairstyle() {
            actor.setHairstyle("光头");
        }
    
        //覆盖钩子方法
        public boolean isBareheaded() {
            return true;
        }	
    }
    
    ```

    ```java
    public class ActorController {
        public Actor construct(ActorBuilder ab) {
            Actor actor;
            ab.buildType();
            ab.buildSex();
            ab.buildFace();
            ab.buildCostume();
            //通过钩子方法来控制产品的构建
            if(!ab.isBareheaded()) {
                ab.buildHairstyle();
            }
            actor=ab.createActor();
            return actor;
        }
    }
    ```

### 建造者模式的优缺点与适用环境

1. 模式优点

  * 客户端不必知道产品内部组成的细节，**将产品本身与产品的创建过程解耦**，使得**相同的创建过程可以创建不同的产品对象**

  * 每一个具体建造者都相对独立，与其他的具体建造者无关，因此**可以很方便地替换具体建造者或增加新的具体建造者**，扩展方便，**符合开闭原则**

  * 可以**更加精细地控制产品的创建过程**

2. 模式缺点

  * 建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，**如果产品之间差距性很大，不适合适用建造者模式**，因此其**使用范围受到一定的限制**。
  * 如果**产品的内部变化复杂**，可能会**需要定义很多具体建造者类**来实现这种变化，导致系统变得很庞大，增加了系统的理解难度和运行成本。

3. 模式适用环境

  * **需要生成的产品对象有复杂的内部结构**，这些产品对象通常包含多个成员变量。
  * **需要生成的产品对象的属性相互依赖**，需要指定其生成顺序。
  * **对象的创建过程独立于创建该对象的类**。在建造者模式中通过引入了指挥者类，将创建过程封装在指挥者类中，而不在建造者类和客户类中。
  * **隔离复杂对象的创建和使用**，并使得相同的创建过程可以创建不同的产品。



## 原型模式

### 原型模式概述

通过复制一个**原型对象**得到多个与原型对象一模一样的新对象。

原型模式的定义：

> 原型模式：使用原型实例指定待创建对象的类型，并**通过复制这个原型来创建新的对象**。

对定义的理解：

* 属于**创建型**设计模式
* **工作原理：**将一个原型对象传给要发动创建的对象（即客户端对象），这个要发动创建的对象**通过请求原型对象复制自己来实现创建过程**。
* 创建新对象（也称为克隆对象）的**工厂**就是**原型类**自身，**工厂方法**由负责复制原型对象的**克隆方法**来实现
* 通过克隆方法所创建的对象是**全新的对象**，它们在内存中拥有新的地址，每一个克隆对象都是**独立**的。
* 通过不同的方式对克隆对象进行修改以后，**可以得到一系列相似但不完全相同的对象**

### 原型模式的结构与实现

#### 原型模式的结构

类图结构：

![image-20220412225301310](https://gitee.com/snailjw/article-images/raw/master/typora/202204122253375.png)

原型模式包含以下3个角色：

* Prototype（抽象原型类）
* ConcretePrototype（具体原型类）
* Client（客户类）

#### 浅克隆与深克隆

**浅克隆（Shallow Clone）：**当原型对象被赋值时，只复制它本身和其中包含的值类型的成员变量，而引用类型的成员变量并没有复制。

![image-20220412225724060](https://gitee.com/snailjw/article-images/raw/master/typora/202204122257112.png)

**深克隆（Deep Clone）：**除了对象本身被复制外，对象所包含的所有成员变量也将被复制。

![image-20220412225823216](https://gitee.com/snailjw/article-images/raw/master/typora/202204122258272.png)

#### 原型模式的实现

**通用的克隆实现方法：**

定义接口：

```java
public interface Prototype {
    public Prototype clone();
}
```

原型对象：

```java
public class ConcretePrototype implements Prototype {
    private String attr; 

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return this.attr;
    }

    //克隆方法
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype(); //创建新对象
        prototype.setAttr(this.attr);
        return prototype;
    }
}
```

调用：

```java
    ……
    ConcretePrototype prototype = new ConcretePrototype();
    prototype.setAttr("Sunny");
    ConcretePrototype copy = (ConcretePrototype)prototype.clone();
    ……
```

**原型模式的实现：**

* Java语言中的clone()方法和Cloneable接口
  * 在Java中，提供了一个`clone()`方法用于实现浅克隆，该方法使用起来很方便，直接调用`super.clone()`方法即可实现克隆。

```java
public class COncretePrototype implements Cloneable {
    ……
    // Shallow Clone
    public Prototype clone(){
        Object object = null;
        try {
            object = super.clone();
        }catch (CloneNotSupportedException exception){
            System.err.println("Not support cloneable");
        }
        return (Prototype)object;
    }
    ……
}
```

调用：

```java
    ……
	Prototype protptype = new ConcretePrototype();
    Prototype copy = protptype.clone();
    ……
```

### 原型模式的应用实例：

实例说明：

>在使用某OA系统时，有些岗位的员工发现他们每周的工作都大同小异，因此在填写工作周报时很多内容都是重复的，为了提高工作周报的创建效率，大家迫切希望有一种机制能够快速创建相同或者相似的周报，包括创建周报的附件。试使用原型模式对该OA系统中的工作周报创建模块进行改进。

实例类图

![image-20220412233217933](https://gitee.com/snailjw/article-images/raw/master/typora/202204122332010.png)

**实例代码：**

Object：抽象原型角色

```java
package java.lang;
public class Object {
    ……
    protected native Object clone() throws CloneNotSupportedException;
    ……
}
```

**深克隆解决方案：**

工作周报类WeeklyLog和附件类Attachmen实现Serializable接口

![image-20220412234216464](https://gitee.com/snailjw/article-images/raw/master/typora/202204122342540.png)





## 附录：

百度云盘下载

链接：https://pan.baidu.com/s/1or3BVso4Cu638ZMRu-A75g 密码：d8e6

![image-20220330202635590](https://gitee.com/snailjw/article-images/raw/master/typora/202203311135346.png)

