1.线程基础
1.1 什么时线程？
线程就是程序代码执行的一条线，在java代码层面看来，是一个方法调用另一个方法，依次排列的方法调用链。
当然，线程时操作系统中的概念，被称为轻量级的进程，是分配cpu资源和调度执行的基本单位。
1.2什么是进程？
进程Process是操作系统中的概念，是应用程序的一次动态执行过程，操作系统会给他分配各种资源，比如内存，文件，以及cpu资源。
每个进程都有自己的内存空间,相对于静态的应用程序二进制代码来说，这个虚拟内存地址空间就是一个副本。
比如，我们用命令行启动一次Java程序。就说启动了一个jvm进程
1.3线程与进程有什么区别？

