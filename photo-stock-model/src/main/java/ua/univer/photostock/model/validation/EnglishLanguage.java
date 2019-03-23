package ua.univer.photostock.model.validation;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnglishLanguageConstraintValidator.class})
public @interface EnglishLanguage {

    String message() default "{javax.validation.constraints.EnglishLanguage.message}";
    
    // 0123456789
    boolean withNumbers() default true;
    //.,?!-:()'"[]{}; \t\n
    boolean withPunctuations() default true;

    //~#$%^&*-+=_\\|/@`!'\";:><,.?{}
    boolean withSpecialSymbols() default true;

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}