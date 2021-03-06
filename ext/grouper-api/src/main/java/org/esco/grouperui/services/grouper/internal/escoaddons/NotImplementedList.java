/**
 * Copyright (C) 2009 GIP RECIA http://www.recia.fr
 * @Author (C) 2009 GIP RECIA <contact@recia.fr>
 * @Contributor (C) 2009 SOPRA http://www.sopragroup.com/
 * @Contributor (C) 2011 Pierre Legay <pierre.legay@recia.fr>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.esco.grouperui.services.grouper.internal.escoaddons;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.odmg.NotImplementedException;
/**
 * @author sopragroup
 */
public class NotImplementedList <T> implements List<T> {

	@Override
	public void add(int index, T element) {
		throw new NotImplementedException();
	}

	@Override
	public boolean add(T e) {
		throw new NotImplementedException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new NotImplementedException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new NotImplementedException();
	}

	@Override
	public void clear() {
		throw new NotImplementedException();
	}

	@Override
	public boolean contains(Object o) {
		throw new NotImplementedException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new NotImplementedException();
	}

	@Override
	public T get(int index) {
		throw new NotImplementedException();
	}

	@Override
	public int indexOf(Object o) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isEmpty() {
		throw new NotImplementedException();
	}

	@Override
	public Iterator<T> iterator() {
		throw new NotImplementedException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new NotImplementedException();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new NotImplementedException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new NotImplementedException();
	}

	@Override
	public T remove(int index) {
		throw new NotImplementedException();
	}

	@Override
	public boolean remove(Object o) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new NotImplementedException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new NotImplementedException();
	}

	@Override
	public T set(int index, T element) {
		throw new NotImplementedException();
	}

	@Override
	public int size() {
		throw new NotImplementedException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new NotImplementedException();
	}

	@Override
	public Object[] toArray() {
		throw new NotImplementedException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new NotImplementedException();
	}

}
