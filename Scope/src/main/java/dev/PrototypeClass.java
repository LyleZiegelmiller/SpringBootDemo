package dev;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prototypeClass")
@Scope("prototype")
public class PrototypeClass extends SomeOtherClass
{

}
