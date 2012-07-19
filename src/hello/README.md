Hello Mediator
==============

This is a simple Cilia Mediator that for any received data in input adds the "Hello, " string at the beginning.

This mediator was configured as follow (see metadata.xml):

- an immediate scheduler: any received data is immediatly processed
- a multicast dispatcher: a copy of the resulting data is dispatched to all outputs of this mediator.

How to compile the source code?
-------------------------------

Type this command at the root directory:

$ mvn clean install

All the dependencies of this project is located on the "lib" directory of this tutorial project.
The resulting jar bundle will be copied on the "bin" directory of this tutorial project.
