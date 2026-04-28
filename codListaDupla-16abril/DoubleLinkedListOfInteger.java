
public class DoubleLinkedListOfInteger {
    // Referencia para o nodo sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o nodo sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(1)
        // Primeiro instancia o nodo
        Node n = new Node(element);
        // Depois, conecta o novo nodo na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n; // Node ant = trailer.prev; ant.next=n;
        trailer.prev = n;
        // Por fim, atualiza o count
        count++;
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        //primeiro verifica se index eh valido
         if (index < 0 || index > count ) // indice invalido
        	throw new IndexOutOfBoundsException();
        // Implementar este método
        if (index == count){ //verifica se meu index é igual a count, se for coloca na ultima posicao
            add(element);
        }
        else{
            //cria o nodo
            Node n = new Node(element);
           //caminha ate a posicao index
           Node aux = getNodeIndex(index);
           //conecta o novo nodo da lista
           n.prev = aux.prev;
           n.next = aux;
           //atualiza as referencias da lista para apontarem para o nodo criado (atualizar o n.next )
            aux.prev.next = n;
            aux.prev = n;
           //atualiza o count
           count++; 
        }
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        // Referencia auxiliar aponta para o primeiro nodo da lista
        Node aux = header.next;
        
        // Faz a referencia auxiliar "caminhar" na lista para procurar element
        for (int i=0; i<count; i++) {
            if (element.equals(aux.element)) { // Se achou element...
                // ...faz a remocao
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;                
                count--;
                return true;
            }
            aux = aux.next;
        }

        // Se nao achou element, nao removeu, retorna false
        return false;	
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        

        // Depois caminha ate a posicao index
        Node aux = getNodeIndex(index);

        // Faz a remocao
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;                
        count--;

        // Retorna o elemento removido
        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        // "Caminha" ate a posicao index
        Node aux = getNodeIndex(index);
        // Retorna o elemento da posicao index
        return aux.element;
    }

    // Retorna uma referencia para o nodo da posicao index
    private Node getNodeIndex(int index) {
        // Cria uma referencia auxiliar
        Node aux = null;
        if (index < count/2) { // Se esta na "primeira metade" da lista...
            // ...percorre do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // Se esta na "segunda metade" da lista...
            // ...percorre do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        // caminha ate a posicao index
        Node aux = getNodeIndex(index);
        //guarda o elemeto que sera trocado
        Integer num = aux.element;
        // coloca o novo elemento na posicao index
        aux.element = element;
        // retorna o elemento que foi trocado
        return num;
    }    
   
    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        // Implementar este método
        return null;
    }  
    
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }   
    
    public void reverse(){
    	Node aux1 = header.next; 
        Node aux2 = trailer.prev;
        Integer aux3 = null;
        for(int i=0; i<count/2; i++) {
            aux3 = aux1.element;
            aux1.element = aux2.element;
            aux2.element = aux3;

            aux1 = aux1.next;
            aux2 = aux2.prev;
        } 
    
    }

    public static Integer getBiggestComumValue (DoubleLinkedListOfInteger l1, DoubleLinkedListOfInteger l2) {
        Integer biggest = null;
        for (int i=0; i<l1.size(); i++) {
            Integer num = l1.get(i);
            if (l2.contains(num)) {
                if (biggest == null || num > biggest) {
                    biggest = num;
                }
            }
        }
        return biggest;
    }

}
