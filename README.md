HelloJOGL
=========

Stand-alone hello world project for JOGL 2.1, easily runnable from command line.


To build: 

From the root directory, open a command line and run 'ant clean all'.


To run:

Drop the 'project-natives-windows-amd64.jar' from the 'dlls' folder to the 'latest' folder.
Then from the root directory, just run 'java -jar latest/project.jar'


Note on the native JOGL DLLs:

This example assumes you are using 64-bit Windows. You'll need to get other appropriate 
native JOGL dlls if this is not the case. All the native dll jars come packaged with JOGL on
the JOGL website: http://jogamp.org/

The current version of JOGL can be downloaded here (requires 7-zip): http://jogamp.org/deployment/jogamp-current/archive/
The file containing the meat of JOGL is 'jogamp-all-platforms.7z'. Look for the 'natives' jar files in the 
'jar' folder of the archive.

'project-natives-windows-amd64.jar' in the dlls directory actually contains the contents of 
both 'gluegen-rt-natives-windows-amd64.jar' and 'jogl-all-natives-windows-amd64.jar'.

If the name of your project's jar isn't 'project', then change 'project' in 
'project-natives-windows-amd64.jar' to whatever the name of your project's jar is.
