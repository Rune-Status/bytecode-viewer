package the.bytecode.club.bytecodeviewer.translation.components;

import the.bytecode.club.bytecodeviewer.translation.TranslatedComponentReference;
import the.bytecode.club.bytecodeviewer.translation.TranslatedComponents;

import javax.swing.*;

/**
 * @author Konloch
 * @since 7/8/2021
 */
public class TranslatedJTextField extends JTextField
{
	public TranslatedJTextField(String text, TranslatedComponents translatedComponents)
	{
		super(text);
		
		if(translatedComponents != null)
		{
			TranslatedComponentReference componentReference = translatedComponents.getTranslatedComponentReference();
			componentReference.runOnUpdate.add(()->
			{
				if(componentReference.value != null && !componentReference.value.isEmpty())
					setText(componentReference.value);
			});
			componentReference.translate();
		}
	}
}
