#ifndef _OBJECT_HPP
#define _OBJECT_HPP

class Object{
private:
	const char ObjectType;
public:
	Object(char _ObjectType);
	virtual void render() = 0;

	char getObjectType();
};

#endif