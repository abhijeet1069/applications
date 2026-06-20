import engine

def start():
    engine.log("Game started")

def update(frame):
    result = engine.heavy_compute(1000000)
    print("frame", frame, result)