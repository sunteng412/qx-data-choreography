package com.linqingxuan.datachoreography.core.dsl.data;
 
import ognl.MemberAccess;

import java.lang.reflect.*;
import java.util.*;
 
/**
 * This class provides methods for setting up and restoring
 * access in a Field.  Java 2 provides access utilities for setting
 * and getting fields that are non-public.  This object provides
 * coarse-grained access controls to allow access to private, protected
 * and package protected members.  This will apply to all classes
 * and members.
 *
 * @author Luke Blanshard (blanshlu@netscape.net)
 * @author Drew Davidson (drew@ognl.org)
 * @version 15 October 1999
 */
public class DefaultMemberAccess implements MemberAccess {
	
	public static final DefaultMemberAccess DEFAULT_MEMBER_ACCESS = new DefaultMemberAccess(Boolean.TRUE);
	
    public boolean      allowPrivateAccess = false;
    public boolean      allowProtectedAccess = false;
    public boolean      allowPackageProtectedAccess = false;
 

	public DefaultMemberAccess(boolean allowAllAccess)
	{
	    this(allowAllAccess, allowAllAccess, allowAllAccess);
	}
 
	public DefaultMemberAccess(boolean allowPrivateAccess, boolean allowProtectedAccess, boolean allowPackageProtectedAccess)
	{
	    super();
	    this.allowPrivateAccess = allowPrivateAccess;
	    this.allowProtectedAccess = allowProtectedAccess;
	    this.allowPackageProtectedAccess = allowPackageProtectedAccess;
	}
 
	/**
	 * Public methods
	 * @param
	 * @return
	 * @description:
	 */
	public boolean getAllowPrivateAccess()
	{
	    return allowPrivateAccess;
	}
 
	public void setAllowPrivateAccess(boolean value)
	{
	    allowPrivateAccess = value;
	}
 
	public boolean getAllowProtectedAccess()
	{
	    return allowProtectedAccess;
	}
 
	public void setAllowProtectedAccess(boolean value)
	{
	    allowProtectedAccess = value;
	}
 
	public boolean getAllowPackageProtectedAccess()
	{
	    return allowPackageProtectedAccess;
	}
 
	public void setAllowPackageProtectedAccess(boolean value)
	{
	    allowPackageProtectedAccess = value;
	}
 
	/**
	 * MemberAccess interface
	 * @param
	 * @return
	 * @description:
	 */
	@Override
    public Object setup(Map context, Object target, Member member, String propertyName)
    {
        Object      result = null;
 
        if (isAccessible(context, target, member, propertyName)) {
            AccessibleObject    accessible = (AccessibleObject)member;
 
            if (!accessible.isAccessible()) {
                result = Boolean.FALSE;
                accessible.setAccessible(true);
            }
        }
        return result;
    }
 
    @Override
	public void restore(Map context, Object target, Member member, String propertyName, Object state)
    {
        if (state != null) {
            ((AccessibleObject)member).setAccessible(((Boolean)state).booleanValue());
        }
    }
 
    /**
        Returns true if the given member is accessible or can be made accessible
        by this object.
     */
	@Override
	public boolean isAccessible(Map context, Object target, Member member, String propertyName)
	{
	    int         modifiers = member.getModifiers();
	    boolean     result = Modifier.isPublic(modifiers);
 
	    if (!result) {
	        if (Modifier.isPrivate(modifiers)) {
	            result = getAllowPrivateAccess();
	        } else {
	            if (Modifier.isProtected(modifiers)) {
	                result = getAllowProtectedAccess();
	            } else {
	                result = getAllowPackageProtectedAccess();
	            }
	        }
	    }
	    return result;
	}
}