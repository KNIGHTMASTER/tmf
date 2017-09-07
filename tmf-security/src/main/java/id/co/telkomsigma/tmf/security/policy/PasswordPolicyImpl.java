package id.co.telkomsigma.tmf.security.policy;

import org.passay.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PasswordPolicyImpl implements IPasswordPolicy{

    @Value("${rule.length}")
    Boolean ruleLength;

    @Value("${rule.length.min}")
    Integer minRuleLength;

    @Value("${rule.length.max}")
    Integer maxRuleLength;

    @Value("${rule.uppercase}")
    Boolean ruleUpperCase;

    @Value("${rule.uppercase.min}")
    Integer minRuleUpperCase;

    @Value("${rule.lowercase}")
    Boolean ruleLowerCase;

    @Value("${rule.lowercase.min}")
    Integer minRuleLowerCase;

    @Value("${rule.digit}")
    Boolean ruleDigit;

    @Value("${rule.digit.min}")
    Integer minRuleDigit;

    @Value("${rule.specialchar}")
    Boolean ruleSpecialChar;

    @Value("${rule.specialchar.min}")
    Integer minRuleSpecialChar;

    @Value("${rule.nowhitespace}")
    Boolean ruleNoWhiteSpace;

    @Override
    public PasswordValidator generatePasswordValidator() {
        List<Rule> rules = new ArrayList<>();
        if (ruleLength)
            rules.add(new LengthRule(minRuleLength, maxRuleLength));
        if (ruleUpperCase)
            rules.add(new CharacterRule(EnglishCharacterData.UpperCase, minRuleUpperCase));
        if (ruleLowerCase)
            rules.add(new CharacterRule(EnglishCharacterData.LowerCase, minRuleLowerCase));
        if (ruleDigit)
            rules.add(new CharacterRule(EnglishCharacterData.Digit, minRuleDigit));
        if (ruleSpecialChar)
            rules.add(new CharacterRule(EnglishCharacterData.Special, minRuleSpecialChar));
        if (ruleNoWhiteSpace)
            rules.add(new WhitespaceRule());
        return new PasswordValidator(rules);
    }

    @Override
    public boolean isValid(String p_Password) {
        return generatePasswordValidator().validate(new PasswordData(p_Password)).isValid();
    }
}
