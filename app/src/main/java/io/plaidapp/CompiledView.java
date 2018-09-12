package io.plaidapp;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.*;
import android.widget.*;

public final class CompiledView {

static <T extends View> T createView(Context context, AttributeSet attrs, View parent, String name, LayoutInflater.Factory factory, LayoutInflater.Factory2 factory2) {
  if (factory2 != null) {
    return (T)factory2.onCreateView(parent, name, context, attrs);
  } else if (factory != null) {
    return (T)factory.onCreateView(name, context, attrs);
  }
  return null;
}

  public static View inflate(Context context) {
    try {
      LayoutInflater inflater = LayoutInflater.from(context);
      LayoutInflater.Factory factory = inflater.getFactory();
      LayoutInflater.Factory2 factory2 = inflater.getFactory2();
      Resources res = context.getResources();
      XmlResourceParser xml = res.getLayout(io.plaidapp.R.layout.activity_home);
      AttributeSet attrs = Xml.asAttributeSet(xml);
      xml.next(); // start document
      xml.next(); // <android.support.v4.widget.DrawerLayout>
      android.support.v4.widget.DrawerLayout v0 = createView(context, attrs, null, "android.support.v4.widget.DrawerLayout", factory, factory2);
      if (v0 == null) v0 = new android.support.v4.widget.DrawerLayout(context, attrs);
;
      xml.next(); // <FrameLayout>
      FrameLayout v2 = createView(context, attrs, v0, "FrameLayout", factory, factory2);
      if (v2 == null) v2 = new FrameLayout(context, attrs);
      ViewGroup.LayoutParams l3 = v0.generateLayoutParams(attrs);
      xml.next(); // <View>
      View v4 = createView(context, attrs, v2, "View", factory, factory2);
      if (v4 == null) v4 = new View(context, attrs);
      ViewGroup.LayoutParams l5 = v2.generateLayoutParams(attrs);
      xml.next(); // </View>
      v2.addView(v4, l5);
      xml.next(); // <android.support.v7.widget.RecyclerView>
      android.support.v7.widget.RecyclerView v6 = createView(context, attrs, v2, "android.support.v7.widget.RecyclerView", factory, factory2);
      if (v6 == null) v6 = new android.support.v7.widget.RecyclerView(context, attrs);
      ViewGroup.LayoutParams l7 = v2.generateLayoutParams(attrs);
      xml.next(); // </android.support.v7.widget.RecyclerView>
      v2.addView(v6, l7);
      xml.next(); // <Toolbar>
      Toolbar v8 = createView(context, attrs, v2, "Toolbar", factory, factory2);
      if (v8 == null) v8 = new Toolbar(context, attrs);
      ViewGroup.LayoutParams l9 = v2.generateLayoutParams(attrs);
      xml.next(); // </Toolbar>
      v2.addView(v8, l9);
      xml.next(); // <ProgressBar>
      ProgressBar v10 = createView(context, attrs, v2, "ProgressBar", factory, factory2);
      if (v10 == null) v10 = new ProgressBar(context, attrs);
      ViewGroup.LayoutParams l11 = v2.generateLayoutParams(attrs);
      xml.next(); // </ProgressBar>
      v2.addView(v10, l11);
      xml.next(); // <ViewStub>
      ViewStub v12 = createView(context, attrs, v2, "ViewStub", factory, factory2);
      if (v12 == null) v12 = new ViewStub(context, attrs);
      ViewGroup.LayoutParams l13 = v2.generateLayoutParams(attrs);
      xml.next(); // </ViewStub>
      v2.addView(v12, l13);
      xml.next(); // <ViewStub>
      ViewStub v14 = createView(context, attrs, v2, "ViewStub", factory, factory2);
      if (v14 == null) v14 = new ViewStub(context, attrs);
      ViewGroup.LayoutParams l15 = v2.generateLayoutParams(attrs);
      xml.next(); // </ViewStub>
      v2.addView(v14, l15);
      xml.next(); // <ImageButton>
      ImageButton v16 = createView(context, attrs, v2, "ImageButton", factory, factory2);
      if (v16 == null) v16 = new ImageButton(context, attrs);
      ViewGroup.LayoutParams l17 = v2.generateLayoutParams(attrs);
      xml.next(); // </ImageButton>
      v2.addView(v16, l17);
      xml.next(); // <ViewStub>
      ViewStub v18 = createView(context, attrs, v2, "ViewStub", factory, factory2);
      if (v18 == null) v18 = new ViewStub(context, attrs);
      ViewGroup.LayoutParams l19 = v2.generateLayoutParams(attrs);
      xml.next(); // </ViewStub>
      v2.addView(v18, l19);
      xml.next(); // </FrameLayout>
      v0.addView(v2, l3);
      xml.next(); // <android.support.v7.widget.RecyclerView>
      android.support.v7.widget.RecyclerView v20 = createView(context, attrs, v0, "android.support.v7.widget.RecyclerView", factory, factory2);
      if (v20 == null) v20 = new android.support.v7.widget.RecyclerView(context, attrs);
      ViewGroup.LayoutParams l21 = v0.generateLayoutParams(attrs);
      xml.next(); // </android.support.v7.widget.RecyclerView>
      v0.addView(v20, l21);
      return v0;
    } catch (Exception e) {
      return null;
    }
  }
}
