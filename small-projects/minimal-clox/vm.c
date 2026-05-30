#include <stdio.h>
#include <stdint.h>

#define STACK_MAX 256
#define CHUNK_MAX 256

typedef double Value;

typedef enum
{
    OP_CONSTANT,
    OP_ADD,
    OP_SUBTRACT,
    OP_MULTIPLY,
    OP_DIVIDE,
    OP_NEGATE,
    OP_RETURN
} OpCode;

typedef struct
{
    uint8_t code[CHUNK_MAX];
    int count;

    Value constants[CHUNK_MAX];
    int constantsCount;
} Chunk;

void initChunk(Chunk *chunk)
{
    chunk->count = 0;
    chunk->constantsCount = 0;
}

void writeChunk(Chunk *chunk, uint8_t byte)
{
    chunk->code[chunk->count++] = byte;
}

int addConstant(Chunk *chunk, Value value)
{
    chunk->constants[chunk->constantsCount] = value;
    return chunk->constantsCount++;
}

typedef struct
{
    Chunk *chunk;
    uint8_t *ip;

    Value stack[STACK_MAX];
    Value *stackTop;
} VM;

VM vm;

void resetStack()
{
    vm.stackTop = vm.stack;
}

void push(Value value)
{
    *vm.stackTop = value;
    vm.stackTop++;
}

Value pop()
{
    vm.stackTop--;
    return *vm.stackTop;
}

void initVM()
{
    resetStack();
}

static uint8_t readByte()
{
    return *vm.ip++;
}

static Value readConstant()
{
    return vm.chunk->constants[readByte()];
}

void run()
{

    for (;;)
    {

        uint8_t instruction = readByte();

        switch (instruction)
        {

        case OP_CONSTANT:
        {
            Value constant = readConstant();
            push(constant);
            break;
        }

        case OP_ADD:
        {
            Value b = pop();
            Value a = pop();
            push(a + b);
            break;
        }

        case OP_SUBTRACT:
        {
            Value b = pop();
            Value a = pop();
            push(a - b);
            break;
        }

        case OP_MULTIPLY:
        {
            Value b = pop();
            Value a = pop();
            push(a * b);
            break;
        }

        case OP_DIVIDE:
        {
            Value b = pop();
            Value a = pop();
            push(a / b);
            break;
        }

        case OP_NEGATE:
        {
            push(-pop());
            break;
        }

        case OP_RETURN:
        {
            printf("Result = %g\n", pop());
            return;
        }
        }
    }
}

int main()
{
    initVM();

    Chunk chunk;
    initChunk(&chunk);

    // Build bytecode for:
    // (1.2 + 3.4) * 5.6

    int constant1 = addConstant(&chunk, 1.2);
    writeChunk(&chunk, OP_CONSTANT);
    writeChunk(&chunk, constant1);

    int constant2 = addConstant(&chunk, 3.4);
    writeChunk(&chunk, OP_CONSTANT);
    writeChunk(&chunk, constant2);

    writeChunk(&chunk, OP_ADD);

    int constant3 = addConstant(&chunk, 5.6);
    writeChunk(&chunk, OP_CONSTANT);
    writeChunk(&chunk, constant3);

    writeChunk(&chunk, OP_MULTIPLY);

    writeChunk(&chunk, OP_RETURN);

    vm.chunk = &chunk;
    vm.ip = vm.chunk->code;

    run();

    return 0;
}

/**
 * (1.2 + 3.4) * 5.6
 *
 * 0 -> 1.2
 * 1 -> 3.4
 * 2 -> 5.6

 Byte Code:
 OP_CONSTANT 0
 OP_CONSTANT 1
 OP_ADD
 OP_CONSTANT 2
 OP_MULTIPLY
 OP_RETURN
 */