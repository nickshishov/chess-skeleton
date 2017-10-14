Arch notes
---

As I understand this task is not only about the chess game. This task is also about how to implement scalable and well-designed system.

Complete diagram of my implementation is - see ```arch/diagram.png```

BoardState I divided into 2 classes. Game - that is facade class and controls base rules of the game. And Board - is the container for figures and can only move figures and provide some state information.

I decided to make Board as an immutable container, "move" method creates new "Board" instance. Why? I want to ensure that it will be changed only in one place - in Game class. This way is predictable and bug-free.

Also, there is one nice feature - now I can store a history of the game and restore game when I need that.

Task also contains nice part - solving place for figure movements information. One of the places is Figure class. But there are some problems: figure will know about "Board" (but I want to make figures more anemic, as it possible); figures have common movements types (queen and bishop). The second problem can be solved in inheritance manner. But this way is not good scalable and will require some workarounds in future with adding new movement types. see - ```arch/diagram2.png```

I decided to create the Movements class(enum) with implementations of movement types. The same approach is to create flight weight objects for all movements types and reuse them. With that solution, I can easily add new movement type and it can be composite of other types.
