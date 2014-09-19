package com.whut.core;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class BaseEntity
{
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }

  public boolean equals(Object object)
  {
    return EqualsBuilder.reflectionEquals(this, object);
  }

  public int hashCode()
  {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
