package main

import (
	"fmt"
	// "time"
)

type Foo struct {
	ch1 chan struct{}
	ch2 chan struct{}
	ch3 chan struct{}
}

func newFoo() Foo {
	f := Foo{
		ch1: make(chan struct{}),
		ch2: make(chan struct{}),
		ch3: make(chan struct{}),
	}
	return f
} 

func (this *Foo) first() {
	fmt.Println("first")
	this.ch1 <- struct{}{}
}

func (this *Foo) second() {
	<- this.ch1
	fmt.Println("second");
	this.ch2 <- struct{}{}
}

func (this *Foo) third() {
	<- this.ch2
	fmt.Println("third");
	this.ch3 <- struct{}{}
}

func main() {
	f := newFoo()
	go func() {
		go f.first()
		go f.second()
		go f.third()
	}()
	<- f.ch3
}