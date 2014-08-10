unscrambler
===========

Unscrambles words and/or finds anagrams. Allows the user to select a list of words (formatted as one word on each line - on UNIX systems, /usr/share/dict/words works). A copy of /usr/share/dict/words has been provided (in root project directory as "words") and a small subset of this file has also been provided (in root project directory as "wordsSmall").

Building
--------

The GUI uses the SWT graphics library. Generally, the appropriate SWT library for your platform must be manually added to the build path in order to build the GUI. The binaries in this repository were compiled on Ubuntu 14.04 (64 bit) and may or may not work on your system depending on whether the SWT library used to compile is compatible with your system.

License
-------

The program itself is licensed under the GNU GPL v3:

    unscrambler
    Copyright (C) 2014  Nicholas Meyer

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
The copy of /usr/share/dict/words is redistributed in accordance with a different license. A copy of this license is provided in the file "license_words".
