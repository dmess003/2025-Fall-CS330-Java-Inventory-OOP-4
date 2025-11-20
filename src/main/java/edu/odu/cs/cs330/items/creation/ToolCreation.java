package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ToolCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "create" since "new" is a reserved keyword in Java.
     */
    public static ToolCreation construct()
    {
        return new ToolCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return null;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 6;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Tool tool = new Tool();

        // Call the appropriate setters...
        tool.setName(tokens[0]);
        tool.setDurability((int) Integer.parseInt(tokens[1]));
        tool.setSpeed((int) Integer.parseInt(tokens[2]));
        tool.setMaterial(tokens[3]);
        tool.setModifier(tokens[4]);
        tool.setModifierLevel((int) Integer.parseInt(tokens[5]));

        return tool;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        // Maybe clone original...
        Tool source = (Tool) original;
        Tool cpy = new Tool();
        
        cpy.setDurability(source.getDurability());
        cpy.setSpeed(source.getSpeed());
        cpy.setMaterial(source.getMaterial());
        cpy.setModifier(source.getModifier());
        cpy.setModifierLevel(source.getModifierLevel());
        cpy.setName(source.getName());

        return cpy;
    }
}
