#include "/Library/Frameworks/Python.framework/Versions/3.12/include/python3.12/Python.h"
#include <stdio.h>

static PyObject *engine_log(PyObject *self, PyObject *args)
{
    const char *msg;
    if (!PyArg_ParseTuple(args, "s", &msg))
        return NULL;
    printf("[ENGINE] %s\n", msg);
    Py_RETURN_NONE;
}

static PyObject *heavy_compute(PyObject *self, PyObject *args)
{
    long n;
    if (!PyArg_ParseTuple(args, "l", &n))
        return NULL;
    long result = 0;
    for (long i = 0; i < n; i++)
        result += i;
    return PyLong_FromLong(result);
}

static PyMethodDef EngineMethods[] = {
    {"log", engine_log, METH_VARARGS, ""},
    {"heavy_compute", heavy_compute, METH_VARARGS, ""},
    {NULL, NULL, 0, NULL}};

static struct PyModuleDef engine_module = {
    PyModuleDef_HEAD_INIT,
    "engine",
    NULL,
    -1,
    EngineMethods};

PyMODINIT_FUNC PyInit_engine(void)
{
    return PyModule_Create(&engine_module);
}