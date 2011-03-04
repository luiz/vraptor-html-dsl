Tired of breaking the links in your JSPs? Using taglibs?

Then this VRaptor plugin may help you!

Take a look at ExampleController for a first impression.

Nice features
=============

Links to controllers
--------------------

It's really bad when we change the URL of a controller's method and we need to
search in our project for every place where it appears and update it, isn't it?
Well, you can avoid it with this library!

In order to create a link to a controller method, say
MyController.myMethod(arg), you create a Url object in the following way:

`Url myLink = url(); to(MyController.class).myMethod(null);`

Now, to put it on the page, just create a `href` attribute and pass it, like this:

`a(href(myLink)).with("Link to my controller")`

List generation
---------------

Oftenly we want to list something in our pages, like Products from a database.
Usually, we do something like a `for` inside a tag, but we cannot do that the
way we are constructing our page using this DSL. So, to accomplish that, you
are going to create an `Elements` object.

The `Elements` object is like a collection: you can put other elements inside
it (using the `append` method). Thus, to create a HTML list based on a Java
collection, you can do the following:

`Collection<String> items;
// fill the collection
Tag itemsInHTML = ul(convertToHTML(items));

NestedElement convertToHTML(Collection<String> items) {
	Elements elements = new Elements();
	for (String item : items) {
		elements.append(li("We have the item " + item));
	}
	return elements;
}`

This is a little uncomfortable, isn't it? Well, if you agree with me, there is
another way, much less verbose, using the `Elements.format` static method:

`Collection<String> items;
// fill the collection
Tag itemsInHTML = ul(format(items).using(this).formatItem(null));

NestedElement formatItem(String item) {
	return li("We have the item " + item);
}`

Pretty much less verbose, isn't it? You can call `format` with any `Iterable`.
Then you call the method `using` to tell the library which method you want it
to call in which object to format each item of the `Iterable` and put it inside
an `Elements` object. In the last example, it will call the `formatItem` method
in this same instance for each String in `items`.

Shortcuts
---------

There are common tasks we need to perform when writing a page, such as
importing CSS, JavaScript and images. For these things, we have shortcut
methods in the PageTagFactory:

*	JavaScript:
	`js("https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js")`
*	CSS:
	`css("/css/example.css")`
* Images:
	`image("/images/image.png", "Alt text")`

Notice that the URL begins with a slash. The shorcut puts the Web Application
Context in that case, just like the `<c:url>` tag in the JSTL.

FormFor
-------

This one is yet to come...

Using it
========

1.	Put vraptor-html-dsl-1.0.jar in your `WEB-INF/lib` folder. You can get a copy from the example project (`example/WebContent/WEB-INF/lib`).
2.	Create a class to represent your page: make it implement the `br.com.caelum.vraptor.html.Page` interface. Take a look at IndexPage and ListPage in the example project.
3.	In your controller, request a PageProcessor in the constructor and make the result of your method be the result of the processing of your Page object, like this:
	`result.use(http()).body(pageProcessor.process(new ListPage(cars)));`

That's it!

How to write a page
===================

You are going to use methods to represent the HTML tags. For example, to create
a `<li>` tag, you use the `li()` method. All methods to create tags are in the
class PageTagFactory and can be static imported.

In order to put some content inside the tag, call the method `with(...)` and
pass the text or the tags to be put inside this tag. For example, to generate
the HTML `<li><b>Interesting!</b></li>`, you are going to write
`li().with(b().with("Interesting!"))`. Notice that, when you need to mix text
and tags inside another tag, you need to use the `text(...)` method, passing
the text inside it; for example: `li().with(text("Some "), b().with("really
interesting"), text(" text!"))` will generate `<li>Some <b>really
interesting</b> text!</li>`.

To put attributes inside a tag, you are also going to use methods like
attributeName("attributeValue"). For instance, if you want to put the id
"reallyNice" and the href "google.com" in your `<a>` tag, you can write
`a(id("reallyNice"), href("google.com"))`. All the currently implemented
attributes (not very much by now) can be created by static methods in the
PageAttributeFactory class.

If you want to create a custom tag or if you need an attribute that is not yet
implemented, it's easy to create your own. Take a look at the
br.com.caelum.vraptor.html.tags.Body class for an example of tag and at the
br.com.caelum.vraptor.html.attributes.Id for an example of attribute.

Pitfall
=======

Unfortunately, the Java language has some words (types or keywords) that
difficult our lives when using the DSL. For instance, if you want to create the
`class` attribute in a tag, you cannot call the `class()` method, because it's
a keyword of the language.

Collaborate!
============

Many attributes are not yet implemented and probably you are going to need one
that is not implemented yet. In that case, please collaborate! Fork the
project, implement it and make a pull request.

Also, you may have ideas of shortcuts or new syntax to include in the project.
Take a look at the issues of the project, open one, give examples. Implement,
also, if you are willing :)

Working with the project
------------------------

The main project uses Maven to manage its dependencies and to generate its JAR.
The example project, inside the `example` folder, is derived from the VRaptor
Blank Project and already comes with an Eclipse Dynamic Web Project file.
