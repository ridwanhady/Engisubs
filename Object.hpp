#ifndef _OBJECT_HPP
#define _OBJECT_HPP

class Object{
private:
	char tipe;
public:
	Object(char _tipe);
	virtual void render() = 0;
};

#endif