package gui;

import java.awt.*;
import java.util.*;

public class RelativeLayout implements LayoutManager2, java.io.Serializable
{
	public final static int X_AXIS = 0;
	public final static int Y_AXIS = 1;


	public final static float LEADING = 0.0f;
	public final static float CENTER = 0.5f;
	public final static float TRAILING = 1.0f;
	public final static float COMPONENT = -1.0f;

	
	public final static int DO_NOTHING = 0;
	public final static int FIRST = 1;
	public final static int LAST = 2;
	public final static int LARGEST = 3;
	public final static int EQUAL = 4;

	private final static int MINIMUM = 0;
	private final static int PREFERRED = 1;

	private HashMap<Component, Float> constraints = new HashMap<Component, Float>();

	private int axis;

	private float alignment = CENTER;
	private int gap;
	private int borderGap;

	private boolean fill = false;

	private int fillGap;

	
	private int roundingPolicy = LARGEST;
	private Container parent;
	private int spaceAvailable;

	public RelativeLayout()
	{
		this(X_AXIS, 0);
	}

	public RelativeLayout(int axis)
	{
		this(axis, 0);
	}
	public RelativeLayout(int axis, int gap)
	{
		
	
		 setAxis(axis);
		setGap(gap);
		setBorderGap( gap);

	}
	public int getAxis() {
		return axis;
	}

	private void setAxis(int axis) {
	if(axis!=X_AXIS
	&& axis!=Y_AXIS)
throw new IllegalArgumentException("INVALID AXIS SPECIFIED");
this.axis=axis;
		
	}

	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap=gap<0?0:gap;
	}
public int getBorderGap() {
	return borderGap;
}
public void setBorderGap(int borderGap) {
	this.borderGap=borderGap<0?0:borderGap;
}

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}
public float getAlignment() {
	return alignment;
}
public void setAlignment(float alignment) {
	this.alignment=alignment>1.0f?1.0f:alignment<0.0f?-1.0f:alignment;
}
public boolean isFill()
{
	return fill;
}
public void setFill(boolean fill)
{
	this.fill = fill;
}
public int getFillGap()
{
	return fillGap;
}
public void setFillGap(int fillGap)
{
	this.fillGap = fillGap;
}
public int getRoundingPolicy()
{
	return roundingPolicy;
}
public void setRoundingPolicy(int roundingPolicy)
{
	this.roundingPolicy = roundingPolicy;
}
public Float getConstraints(Component component)
{
	return (Float)constraints.get(component);
}
public void addLayoutComponent(Component component, Object constraint)
{
	if (constraint == null || constraint instanceof Float)
	{
		constraints.put(component, (Float)constraint);
	}
	else
		throw new IllegalArgumentException("Constraint parameter must be of type Float");
}
public void removeLayoutComponent(Component comp) {}
public Dimension preferredLayoutSize(Container parent)
{
	synchronized (parent.getTreeLock())
	{
		return getLayoutSize(parent, PREFERRED);
	}
}
public Dimension minimumLayoutSize(Container parent)
{
	synchronized (parent.getTreeLock())
	{
		return getLayoutSize(parent, MINIMUM);
	}
}
public void layoutContainer(Container parent)
{
	synchronized (parent.getTreeLock())
	{
		if (axis == X_AXIS)
			layoutContainerHorizontally(parent);
		else
			layoutContainerVertically(parent);
	}
}
private void layoutContainerHorizontally(Container parent)
{
	int components = parent.getComponentCount();
	int visibleComponents = getVisibleComponents( parent );

	if (components == 0) return;

	//  Determine space available for components using relative sizing

	float relativeTotal = 0.0f;
	Insets insets = parent.getInsets();
	int spaceAvailable = parent.getSize().width
					   - insets.left
					   - insets.right
					   - ((visibleComponents - 1) * gap)
					   - (2 * borderGap);

	for (int i = 0 ; i < components ; i++)
	{
		Component component = parent.getComponent(i);

		if (! component.isVisible()) continue;

		Float constraint = constraints.get(component);

		if (constraint == null)
		{
			Dimension d = component.getPreferredSize();
			spaceAvailable -= d.width;
		}
		else
		{
			relativeTotal += constraint.doubleValue();
		}
	}

	//  Allocate space to each component using relative sizing

	int[] relativeSpace = allocateRelativeSpace(parent, spaceAvailable, relativeTotal);

	//  Position each component in the container

	int x = insets.left + borderGap;
	int y = insets.top;
	int insetGap = insets.top + insets.bottom;
	int parentHeight = parent.getSize().height - insetGap;

	for (int i = 0 ; i < components ; i++)
	{
		Component component = parent.getComponent(i);

		if (! component.isVisible()) continue;

		if (i > 0)
			x += gap;

		Dimension d = component.getPreferredSize();

		if (fill)
			d.height = parentHeight - fillGap;

		Float constraint = constraints.get(component);

		if (constraint == null)
		{
			component.setSize( d );
			int locationY = getLocationY(component, parentHeight) + y;
			component.setLocation(x, locationY);
			x += d.width;
		}
		else
		{
			int width = relativeSpace[i];
			component.setSize(width, d.height);
			int locationY = getLocationY(component, parentHeight) + y;
			component.setLocation(x, locationY);
			x += width;
		}
	}
}
private int getLocationY(Component component, int height)
{
	//  Use the Container alignment policy

	float alignmentY = alignment;

	//  Override with the Component alignment

	if (alignmentY == COMPONENT)
		alignmentY = component.getAlignmentY();

	float y = (height - component.getSize().height) * alignmentY;
	return (int)y;
}
private void layoutContainerVertically(Container parent)
{
	int components = parent.getComponentCount();
	int visibleComponents = getVisibleComponents( parent );

	if (components == 0) return;

	//  Determine space available for components using relative sizing

	float relativeTotal = 0.0f;
	Insets insets = parent.getInsets();
	int spaceAvailable = parent.getSize().height
					   - insets.top
					   - insets.bottom
					   - ((visibleComponents - 1) * gap)
					   - (2 * borderGap);

	for (int i = 0 ; i < components ; i++)
	{
		Component component = parent.getComponent(i);

		if (! component.isVisible()) continue;

		Float constraint = constraints.get(component);

		if (constraint == null)
		{
			Dimension d = component.getPreferredSize();
			spaceAvailable -= d.height;
		}
		else
		{
			relativeTotal += constraint.doubleValue();
		}
	}
}
int[] relativeSpace = allocateRelativeSpace(parent, spaceAvailable, relativeTotal);
int x = insets.left;
int y = insets.top + borderGap;
int insetGap = insets.left + insets.right;
int parentWidth = parent.getSize().width - insetGap;

for (int i = 0 ; i < components ; i++)
{
	Component component = parent.getComponent(i);

	if (! component.isVisible()) continue;

	if (i > 0)
		y += gap;

	Dimension d = component.getPreferredSize();

	if (fill)
		d.width = parentWidth - fillGap;

	Float constraint = constraints.get(component);

	if (constraint == null)
	{
		component.setSize( d );
		int locationX = getLocationX(component, parentWidth) + x;
		component.setLocation(locationX, y);
		y += d.height;
	}
	else
	{
		int height = relativeSpace[i];
		component.setSize(d.width, height);
		int locationX = getLocationX(component, parentWidth) + x;
		component.setLocation(locationX, y);
		y += height;
	}

}

private int getLocationX(Component component, int width)
{
	//  Use the Container alignment policy

	float alignmentX = alignment;

	//  Override with the Component alignment

	if (alignmentX == COMPONENT)
		alignmentX = component.getAlignmentX();

	float x = (width - component.getSize().width) * alignmentX;
	return (int)x;
}
}
private int[] allocateRelativeSpace(Container parent, int spaceAvailable, float relativeTotal)
{
	int spaceUsed = 0;
	int components = parent.getComponentCount();
	int[] relativeSpace = new int[components];

	for (int i = 0 ; i < components ; i++)
	{
		relativeSpace[i] = 0;

		if (relativeTotal > 0 && spaceAvailable > 0)
		{
			Component component = parent.getComponent(i);
			Float constraint = constraints.get(component);

			if (constraint != null)
			{
				int space = (int)(Math.round(spaceAvailable * constraint.floatValue() / relativeTotal));
				relativeSpace[i] = space;
				spaceUsed += space;
			}
		}
	}

	int spaceRemaining = spaceAvailable - spaceUsed;

	if (relativeTotal > 0 && spaceRemaining != 0)
		adjustForRounding(relativeSpace, spaceRemaining);

	return relativeSpace;
}

protected void adjustForRounding(int[] relativeSpace, int spaceRemaining)
{
	switch(roundingPolicy)
	{
		case DO_NOTHING:
			break;
		case FIRST:
			adjustFirst(relativeSpace, spaceRemaining);
			break;
		case LAST:
			adjustLast(relativeSpace, spaceRemaining);
			break;
		case LARGEST:
			adjustLargest(relativeSpace, spaceRemaining);
			break;
		case EQUAL:
			adjustEqual(relativeSpace, spaceRemaining);
			break;
		default:
			adjustLargest(relativeSpace, spaceRemaining);
	}
}
private void adjustFirst(int[] relativeSpace, int spaceRemaining)
{
	for (int i = 0; i < relativeSpace.length; i++)
	{
		if (relativeSpace[i] > 0)
		{
			relativeSpace[i] += spaceRemaining;
			break;
		}
	}
}
private void adjustLast(int[] relativeSpace, int spaceRemaining)
{
	for (int i = relativeSpace.length - 1; i > 0; i--)
	{
		if (relativeSpace[i] > 0)
		{
			relativeSpace[i] += spaceRemaining;
			break;
		}
	}
}
private void adjustLargest(int[] relativeSpace, int spaceRemaining)
{
	int largest = 0;
	int largestSpace = 0;

	for (int i = 0; i < relativeSpace.length; i++)
	{
		int space = relativeSpace[i];

		if (space > 0)
		{
			if (largestSpace <= space)
			{
				largestSpace = space;
				largest = i;
			}
		}
	}

	relativeSpace[largest] += spaceRemaining;
}
private void adjustEqual(int[] relativeSpace, int spaceRemaining)
{
	for (int i = 0; i < relativeSpace.length; i++)
	{
		if (relativeSpace[i] > 0)
		{
			if (spaceRemaining > 0)
			{
				relativeSpace[i]++;
				spaceRemaining--;
			}
			else
			{
				relativeSpace[i]--;
				spaceRemaining++;
			}

			if (spaceRemaining == 0)
				break;
		}
	}
}
private Dimension getLayoutSize(Container parent, int type)
{
	int width = 0;
	int height = 0;
	int components = parent.getComponentCount();
	int visibleComponents = getVisibleComponents( parent );

	for (int i = 0 ; i < components ; i++)
	{
		Component component = parent.getComponent(i);

		if (! component.isVisible()) continue;

		Dimension d = getDimension(component, type);

		if (axis == X_AXIS)
		{
			width += d.width;
			height = Math.max(height, d.height);
		}
		else
		{
			width = Math.max(width, d.width);
			height += d.height;
		}
	}

	Insets insets = parent.getInsets();
	int totalGap = ((visibleComponents - 1) * gap) + (2 * borderGap);

	if (axis == X_AXIS)
	{
		width += insets.left + insets.right + totalGap;
		height += insets.top + insets.bottom;
	}
	else
	{
		width += insets.left + insets.right;
		height += insets.top + insets.bottom + totalGap;
	}

	Dimension size = new Dimension(width, height);
	return size;
}

private int getVisibleComponents(Container container)
{
	int visibleComponents = 0;

	for (Component component : container.getComponents())
	{
    	if (component.isVisible())
    		visibleComponents++;
	}

	return visibleComponents;
}

private Dimension getDimension(Component component, int type)
{
	switch (type)
	{
		case PREFERRED: return component.getPreferredSize();
		case MINIMUM:   return component.getMinimumSize();
		default: return new Dimension(0, 0);
	}
}
public Dimension maximumLayoutSize(Container target)
{
	return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
}
public float getLayoutAlignmentX(Container parent)
{
	return 0.5f;
}
public float getLayoutAlignmentY(Container parent)
{
	return 0.5f;
}
public void invalidateLayout(Container target)
{

}
public String toString()
{
	return getClass().getName()
		+ "[axis=" + axis
		+ ",gap=" + gap
		+ "]";
}
}
}
