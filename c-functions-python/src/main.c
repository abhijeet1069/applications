#include "engine.h"

int main()
{
    PyImport_AppendInittab("engine", PyInit_engine);
    Py_Initialize();
    PyRun_SimpleString(
        "import sys\n"
        "sys.path.append('./src')\n");
    PyObject *module = PyImport_ImportModule("game");
    if (!module)
    {
        PyErr_Print();
        return 1;
    }
    PyObject *start = PyObject_GetAttrString(module, "start");

    PyObject *update = PyObject_GetAttrString(module, "update");

    PyObject_CallObject(start, NULL);
    for (int frame = 0; frame < 60; frame++)
    {
        PyObject *args = Py_BuildValue("(i)", frame);
        PyObject_CallObject(update, args);
        Py_DECREF(args);
    }
    Py_Finalize();
}