CC      := gcc
TARGET  := engine_app

SRC     := $(wildcard src/*.c)
OBJ     := $(SRC:.c=.o)

PY_CFLAGS := $(shell python3-config --cflags)
PY_LDFLAGS := $(shell python3-config --embed --ldflags)

CFLAGS  := -Wall -Wextra -std=c17 -O2 $(PY_CFLAGS)
LDFLAGS := $(PY_LDFLAGS)

.PHONY: all clean run debug

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) $(OBJ) $(LDFLAGS) -o $@

src/%.o: src/%.c
	$(CC) $(CFLAGS) -c $< -o $@

run: $(TARGET)
	./$(TARGET)

debug: CFLAGS := -Wall -Wextra -std=c17 -g -O0 $(PY_CFLAGS)
debug: clean all

clean:
	rm -f $(OBJ) $(TARGET)