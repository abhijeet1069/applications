# Extending C programs

C programs can be extended using python code, and both run as a same process.


## Output

Engine app picked game.py and executed.
So langugaes

```bash
satyam@satyam-2 c-functions-python % ./engine_app
[ENGINE] Game started
frame 0 499999500000
frame 1 499999500000
frame 2 499999500000
frame 3 499999500000
frame 4 499999500000
frame 5 499999500000
frame 6 499999500000
frame 7 499999500000
frame 8 499999500000
frame 9 499999500000
frame 10 499999500000
frame 11 499999500000
frame 12 499999500000
frame 13 499999500000
frame 14 499999500000
frame 15 499999500000
frame 16 499999500000
frame 17 499999500000
frame 18 499999500000
frame 19 499999500000
frame 20 499999500000
frame 21 499999500000
frame 22 499999500000
frame 23 499999500000
frame 24 499999500000
frame 25 499999500000
frame 26 499999500000
frame 27 499999500000
frame 28 499999500000
frame 29 499999500000
frame 30 499999500000
frame 31 499999500000
frame 32 499999500000
frame 33 499999500000
frame 34 499999500000
frame 35 499999500000
frame 36 499999500000
frame 37 499999500000
frame 38 499999500000
frame 39 499999500000
frame 40 499999500000
frame 41 499999500000
frame 42 499999500000
frame 43 499999500000
frame 44 499999500000
frame 45 499999500000
frame 46 499999500000
frame 47 499999500000
frame 48 499999500000
frame 49 499999500000
frame 50 499999500000
frame 51 499999500000
frame 52 499999500000
frame 53 499999500000
frame 54 499999500000
frame 55 499999500000
frame 56 499999500000
frame 57 499999500000
frame 58 499999500000
frame 59 499999500000
satyam@satyam-2 c-functions-python % 
```

## Typical architecture for games

+----------------------+
| Python Scripts       |
| game.py              |
| enemy.py             |
| quest.py             |
+----------+-----------+
           |
           v
+----------+-----------+
| C++ Engine           |
| Scene Graph          |
| Physics              |
| Renderer             |
| Audio                |
| Pathfinding          |
+----------------------+

## Physics Simulator Stack

physics-simulator/
├── engine/
│   ├── vector.cpp
│   ├── particle.cpp
│   ├── spring.cpp
│   └── world.cpp
│
├── renderer/
│   └── SDL2
│
├── scripts/
│   └── simulation.py
│
└── main.cpp