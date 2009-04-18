/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package serializers.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import org.apache.commons.lang.builder.HashCodeBuilder;
import com.facebook.thrift.*;

import com.facebook.thrift.protocol.*;
import com.facebook.thrift.transport.*;

public class MediaContent implements TBase, java.io.Serializable {
private List<Image> image;
public static final int IMAGE = 1;
private Media media;
public static final int MEDIA = 2;

public final Isset __isset = new Isset();
public static final class Isset implements java.io.Serializable {
public boolean image = false;
public boolean media = false;
}

public MediaContent() {
}

public MediaContent(
List<Image> image,
Media media)
{
this();
this.image = image;
this.__isset.image = (image != null);
this.media = media;
this.__isset.media = (media != null);
}

public int getImageSize() {
return (this.image == null) ? 0 : this.image.size();
}

public java.util.Iterator<Image> getImageIterator() {
return (this.image == null) ? null : this.image.iterator();
}

public void addToImage(Image elem) {
if (this.image == null) {
this.image = new ArrayList<Image>();
}
this.image.add(elem);
this.__isset.image = true;
}

public List<Image> getImage() {
return this.image;
}

public void setImage(List<Image> image) {
this.image = image;
this.__isset.image = (image != null);
}

public void unsetImage() {
this.image = null;
this.__isset.image = false;
}

public Media getMedia() {
return this.media;
}

public void setMedia(Media media) {
this.media = media;
this.__isset.media = (media != null);
}

public void unsetMedia() {
this.media = null;
this.__isset.media = false;
}

public void setFieldValue(int fieldID, Object value) {
switch (fieldID) {
case IMAGE:
setImage((List<Image>)value);
break;

case MEDIA:
setMedia((Media)value);
break;

default:
  throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
}
}

public Object getFieldValue(int fieldID) {
switch (fieldID) {
case IMAGE:
return getImage();

case MEDIA:
return getMedia();

default:
  throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
}
}

public boolean equals(Object that) {
if (that == null)
  return false;
if (that instanceof MediaContent)
  return this.equals((MediaContent)that);
return false;
}

public boolean equals(MediaContent that) {
if (that == null)
  return false;

boolean this_present_image = true && (this.__isset.image) && (this.image != null);
boolean that_present_image = true && (that.__isset.image) && (that.image != null);
if (this_present_image || that_present_image) {
if (!(this_present_image && that_present_image))
  return false;
if (!this.image.equals(that.image))
  return false;
}

boolean this_present_media = true && (this.__isset.media) && (this.media != null);
boolean that_present_media = true && (that.__isset.media) && (that.media != null);
if (this_present_media || that_present_media) {
if (!(this_present_media && that_present_media))
  return false;
if (!this.media.equals(that.media))
  return false;
}

return true;
}

public int hashCode() {
HashCodeBuilder builder = new HashCodeBuilder();

boolean present_image = true && (__isset.image) && (image != null);
builder.append(present_image);
if (present_image)
  builder.append(image);

boolean present_media = true && (__isset.media) && (media != null);
builder.append(present_media);
if (present_media)
  builder.append(media);

return builder.toHashCode();
}

public void read(TProtocol iprot) throws TException {
TField field;
iprot.readStructBegin();
while (true)
{
field = iprot.readFieldBegin();
if (field.type == TType.STOP) { 
break;
}
switch (field.id)
{
case IMAGE:
if (field.type == TType.LIST) {
{
TList _list4 = iprot.readListBegin();
this.image = new ArrayList<Image>(_list4.size);
for (int _i5 = 0; _i5 < _list4.size; ++_i5)
{
Image _elem6 = new Image();
_elem6 = new Image();
_elem6.read(iprot);
this.image.add(_elem6);
}
iprot.readListEnd();
}
this.__isset.image = true;
} else { 
  TProtocolUtil.skip(iprot, field.type);
}
break;
case MEDIA:
if (field.type == TType.STRUCT) {
this.media = new Media();
this.media.read(iprot);
this.__isset.media = true;
} else { 
  TProtocolUtil.skip(iprot, field.type);
}
break;
default:
  TProtocolUtil.skip(iprot, field.type);
  break;
}
iprot.readFieldEnd();
}
iprot.readStructEnd();
}

public void write(TProtocol oprot) throws TException {
TStruct struct = new TStruct("MediaContent");
oprot.writeStructBegin(struct);
TField field = new TField();
if (this.image != null) {
if (this.__isset.image) {
field.name = "image";
field.type = TType.LIST;
field.id = IMAGE;
oprot.writeFieldBegin(field);
{
oprot.writeListBegin(new TList(TType.STRUCT, this.image.size()));
for (Image _iter7 : this.image){
_iter7.write(oprot);
}
oprot.writeListEnd();
}
oprot.writeFieldEnd();
}
}
if (this.media != null) {
if (this.__isset.media) {
field.name = "media";
field.type = TType.STRUCT;
field.id = MEDIA;
oprot.writeFieldBegin(field);
this.media.write(oprot);
oprot.writeFieldEnd();
}
}
oprot.writeFieldStop();
oprot.writeStructEnd();
}

public String toString() {
StringBuilder sb = new StringBuilder("MediaContent(");
boolean first = true;

if (__isset.image) {
if (!first) sb.append(", ");
sb.append("image:");
sb.append(this.image);
first = false;
}
if (__isset.media) {
if (!first) sb.append(", ");
sb.append("media:");
sb.append(this.media);
first = false;
}
sb.append(")");
return sb.toString();
}

}
